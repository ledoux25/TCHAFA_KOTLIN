package com.example.tchafa.navigation

sealed class Screen(val route: String ) {

    object Login: Screen(route = "login_screen")
    object SignUp: Screen(route = "signup_screen")
    object NeedDetail: Screen(route = "need_detail_screen")

    object OnBoarding : Screen(route = "onboarding")

    object HomeScreen : Screen (route = "home_screen")

    object NewPublicationScreen : Screen (route = "new_pup_screen")

    object ProfileForm : Screen (route = "profile_form")

    object NeedModifyView : Screen (route = "modify_need")


    object RecommendationHome : Screen (route = "recom_screen")

    object PublicationHome : Screen (route = "publi_screen")

    object NeedHome : Screen (route = "NeedHome_screen")


}