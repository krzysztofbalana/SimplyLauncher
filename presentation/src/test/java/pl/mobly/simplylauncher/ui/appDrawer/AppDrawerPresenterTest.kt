package pl.mobly.simplylauncher.ui.appDrawer

import android.content.Context
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class AppDrawerPresenterTest {

	lateinit var systemUnderTest: AppDrawerPresenter
	@Mock lateinit var dummyView:AppDrawerContract.View
	lateinit var context: Context

	@Before
	fun setUp() {
		context = Mockito.mock(Context::class.java)
		systemUnderTest = AppDrawerPresenter()
		systemUnderTest.bind(dummyView)
	}

	@Test
	fun shouldBeAlbeToLaunchGridViewOnStart() {
		verify(dummyView).showGrid()
	}

	@Test
	fun shouldBeAbleToShowGridWhenUserTapsOnProperValue() {
		Mockito.reset(dummyView)
		val tappedTab:Int = 2

		systemUnderTest.onSwitcherTapped(tappedTab)

		verify(dummyView).showGrid()
	}

	@Test
	fun shouldBeAbleToShowListWhenUserTapsOnProperValue() {
		val tappedTab:Int = 1

		systemUnderTest.onSwitcherTapped(tappedTab)

		verify(dummyView).showList()
	}

    @Test
    fun shouldBeAbleToSetViewToDefaultPresentationMode() {
        Mockito.reset(dummyView)
		systemUnderTest.setDefaultAppsPresentationMode()

        verify(dummyView).showGrid()
    }
}