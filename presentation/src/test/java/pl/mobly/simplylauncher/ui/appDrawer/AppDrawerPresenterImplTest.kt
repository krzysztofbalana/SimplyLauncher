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
class AppDrawerPresenterImplTest {

	lateinit var systemUnderTest:AppDrawerPresenterImpl
	@Mock lateinit var dummyView:AppDrawerView
	lateinit var context: Context

	@Before
	fun setUp() {
		context = Mockito.mock(Context::class.java)
		systemUnderTest = AppDrawerPresenterImpl()
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

}