package com.github.aayman93.gadsleaderboard

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.aayman93.gadsleaderboard.leaderboard.adapters.LearningLeadersAdapter
import com.github.aayman93.gadsleaderboard.leaderboard.adapters.SkillIqLeadersAdapter
import com.github.aayman93.gadsleaderboard.models.LearningLeader
import com.github.aayman93.gadsleaderboard.models.SkillIqLeader

@BindingAdapter("listData")
fun bindLearningLeadersRecycler(recyclerView: RecyclerView, data: List<LearningLeader>) {
    val adapter = recyclerView.adapter as LearningLeadersAdapter
    adapter.data = data.sortedByDescending { it.hours }
}

@BindingAdapter("listData")
fun bindSkillIqLeadersRecycler(recyclerView: RecyclerView, data: List<SkillIqLeader>) {
    val adapter = recyclerView.adapter as SkillIqLeadersAdapter
    adapter.data = data.sortedByDescending { it.score }
}

@BindingAdapter("badgeUrl")
fun bindBadgeImage(imageView: ImageView, badgeUrl: String) {
    Glide.with(imageView.context)
        .load(badgeUrl)
        .into(imageView)
}

@BindingAdapter("learningHours")
fun bindLearningHoursText(textView: TextView, learningLeader: LearningLeader) {
    val text = "${learningLeader.hours} Learning hours, ${learningLeader.country}"
    textView.text = text
}

@BindingAdapter("skillIqScore")
fun bindSkillIqScoreText(textView: TextView, skillIqLeader: SkillIqLeader) {
    val text = "${skillIqLeader.score} Skill IQ score, ${skillIqLeader.country}"
    textView.text = text
}