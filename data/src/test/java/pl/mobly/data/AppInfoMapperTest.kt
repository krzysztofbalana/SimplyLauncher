package pl.mobly.data

import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import kotlin.test.assertTrue

@RunWith(MockitoJUnitRunner::class)
class AppInfoMapperTest {
	@Mock lateinit var packageManger:PackageManager
	@Mock lateinit var applicationInfo:ApplicationInfo

	private lateinit var systemUnderTest: AppInfoMapper
	private lateinit var list:MutableList<ApplicationInfo>

	@Before
	fun setUp() {
		systemUnderTest = AppInfoMapper
		list = initAppInfoList()
	}

	private fun initAppInfoList(): MutableList<ApplicationInfo> {
		val returnableList = mutableListOf<ApplicationInfo>()
		for (i in 1..20) {
			returnableList.add(applicationInfo)
		}
		return returnableList
	}

	@Test
	fun shouldBeAbleToReturnInstalledAppName() {
		simulateLoadingLabelReturnsNonNullValue()
		val mappedList = systemUnderTest.mapToDomain(list, packageManger)
		assertTrue { mappedList.all { it.name != null } }
	}

	@Test
	fun shouldBeAbleToReturnIcons() {
		simulateLoadingLabelReturnsNonNullValue()
		val mapToDomain = systemUnderTest.mapToDomain(list, packageManger)
		assertTrue { mapToDomain.all { it.icon != null } }
	}

	private fun simulateLoadingLabelReturnsNonNullValue() {
		var expectedValue:CharSequence = "kot"
		whenever(applicationInfo.loadLabel(packageManger)).thenReturn(expectedValue)
	}
}

