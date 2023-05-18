package com.example.tchafa.ui.theme.onBoarding

import com.example.tchafa.R

class OnBoardingItem(
    val title : Int,
    val text : Int,
    val image: Int,
) {


    companion object {


        fun get():List<OnBoardingItem>{
            return  listOf(
                OnBoardingItem(R.string.onBoardingTitle1,R.string.onBoardingTitle1,R.drawable.onboarding1),
                OnBoardingItem(R.string.onBoardingTitle2,R.string.onBoardingTitle2,R.drawable.img),
                OnBoardingItem(R.string.onBoardingTitle3,R.string.onBoardingTitle3,R.drawable.img_1),
            )
        }
    }

}