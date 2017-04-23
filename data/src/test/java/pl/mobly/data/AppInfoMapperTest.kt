package pl.mobly.data

import android.content.pm.ApplicationInfo
import org.junit.Before
import org.junit.Test
import kotlin.test.assertTrue

class AppInfoMapperTest {

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
			val applicationInfo = ApplicationInfo()
			applicationInfo.packageName = "kotek"
			applicationInfo.icon = 10
			returnableList.add(applicationInfo)
		}
		return returnableList
	}

	@Test
	fun shouldBeAbleToReturnInstalledAppName() {
		val mappedList = systemUnderTest.mapToDomain(list)
		assertTrue { mappedList.all { it.name != null } }
	}

	@Test
	fun shouldBeAbleToReturnIconResources() {
		val mappedList = systemUnderTest.mapToDomain(list)
		assertTrue { mappedList.any { it.icon != 0} }
	}
}

