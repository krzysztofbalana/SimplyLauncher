package pl.mobly.data

import android.content.Intent
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import kotlin.test.assertTrue

class PackageManagerResourceTest {

	lateinit var systemUnderTest: PackageManagerResource

	lateinit var packageManager: PackageManager

	lateinit var mockedListOfApps: MutableList<ApplicationInfo>

	lateinit var mockedListOdAppsInfo: MutableList<ApplicationInfo>

	@Before
	fun setUp() {
		packageManager = mock()
		mockedListOfApps = mock()
		systemUnderTest = PackageManagerResource(packageManager)

		mockedListOdAppsInfo = initList()
	}

	private fun initList(): MutableList<ApplicationInfo> {
		val listOfInstalledApps = mutableListOf<ApplicationInfo>()
		for (i in 1..10) {
			val applicationInfo = ApplicationInfo()
			applicationInfo.packageName = "kotek"
			listOfInstalledApps.add(applicationInfo)
		}
		return listOfInstalledApps
	}

	@Test
	fun shouldBeAbleToLoadAnReturnOnlyNonSystemApps() {
		simulatePackageManagerReturnedInstalledApps()
		val installedApps = systemUnderTest.loadInstalledApps()
		assertTrue { installedApps.size != 0 }
	}

	private fun simulatePackageManagerReturnedInstalledApps() {
		whenever(packageManager.getInstalledApplications(PackageManager.GET_META_DATA)).thenReturn(mockedListOdAppsInfo)
		whenever(packageManager.getLaunchIntentForPackage(anyString())).thenReturn(Intent())
	}

}