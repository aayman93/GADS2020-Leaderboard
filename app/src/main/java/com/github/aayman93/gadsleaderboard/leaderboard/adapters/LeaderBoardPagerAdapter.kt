package com.github.aayman93.gadsleaderboard.leaderboard.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.github.aayman93.gadsleaderboard.R
import com.github.aayman93.gadsleaderboard.leaderboard.LearningLeadersFragment
import com.github.aayman93.gadsleaderboard.leaderboard.SkillIqLeadersFragment

class LeaderBoardPagerAdapter(val fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> LearningLeadersFragment()
            else -> SkillIqLeadersFragment()
        }
    }

    fun getTitle(position: Int): String {
        return when (position) {
            0 -> fragment.requireContext().getString(R.string.learning_leaders_fragment_title)
            else -> fragment.requireContext().getString(R.string.skill_iq_fragment_title)
        }
    }
}