package com.example.tchafa.navigation

sealed class Screen(val route: String ) {

    object Login: Screen(route = "login_screen")
    object SignUp: Screen(route = "signup_screen")
    object NeedDetail: Screen(route = "need_detail_screen")

    object OnBoarding : Screen(route = "onboarding")

    object HomeScreen : Screen (route = "home_screen")

    object NewPublicationScreen : Screen (route = "new_pup_screen")

    object ProfileScreen: Screen (route = "profile_screen")

    object NeedModifyView : Screen (route = "modify_need")


    object RecommendationHome : Screen (route = "recom_screen")

    object publicationHome : Screen (route = "publi_screen")

    object NeedHome : Screen (route = "NeedHome_screen")

    object LoginHome : Screen (route = "login_home")
    object NeedDetails: Screen (route = "need_details")

    object PublicationDetail: Screen (route = "publication_detail_screen")

    object OLPublications: Screen (route = "online_publication_screen")

    object OLPublicationsDetail: Screen (route = "online_publication_detail_screen")

    object ProfileForm: Screen (route = "profile_form_screen")








}