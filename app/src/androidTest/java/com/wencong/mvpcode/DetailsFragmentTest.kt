package com.wencong.mvpcode

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class DetailsFragmentTest {
//
//    @Rule
//    var mActivityTestRule: ActivityTestRule<MainActivity> = ActivityTestRule(
//        MainActivity::class.java
//    )

//    @Test
//    fun testOpenDetail() {
//        // Create a mock NavController
//        val mockNavController = mock(NavController::class.java)
//
//        // Create a graphical FragmentScenario for the TitleScreen
//        val titleScenario = launchFragmentInContainer<ListFragment>()
//
//        // Set the NavController property on the fragment
//        titleScenario.onFragment { fragment ->
//            Navigation.setViewNavController(fragment.requireView(), mockNavController)
//        }
//        onView(
//            allOf(
//                withText("data1"),
//                hasSibling(ViewMatchers.withText("This is simulated data 1, which is displayed and used on the interface"))
//            )
//        ).perform(ViewActions.click())
//        verify(mockNavController).navigate(R.id.action_listFragment_to_detailFragment)
//    }

//    @Test
//    fun testEventFragment() {
//        onView(
//            CoreMatchers.allOf(
//                ViewMatchers.withText("data1"),
//                ViewMatchers.hasSibling(ViewMatchers.withText("This is simulated data 1, which is displayed and used on the interface"))
//            )
//        ).perform(click())
//        onView(withId(R.id.tvDetailTitle)).check(matches(equalTo("data1")))
//        pressBack()
//        onView(withId(R.id.tvDetailTitle)).check(matches(not(isDisplayed())))
//    }

//    @Test
//    fun testNavigationPressBack() {
//        val navController = TestNavHostController(
//            ApplicationProvider.getApplicationContext()
//        )
//        val titleScenario = launchFragmentInContainer<ListFragment>()
//        titleScenario.onFragment { fragment ->
//            navController.setGraph(R.navigation.nav_graph)
//            Navigation.setViewNavController(fragment.requireView(), navController)
//        }
//        onView(
//            CoreMatchers.allOf(
//                ViewMatchers.withText("data1"),
//                ViewMatchers.hasSibling(ViewMatchers.withText("This is simulated data 1, which is displayed and used on the interface"))
//            )
//        ).perform(click())
//        onView(withId(R.id.tvDetailTitle)).check(matches(isDisplayed()))
//    }
}