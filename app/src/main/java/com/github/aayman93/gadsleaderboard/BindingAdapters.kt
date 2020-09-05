package com.github.aayman93.gadsleaderboard

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.github.aayman93.gadsleaderboard.models.LearningLeader
import com.github.aayman93.gadsleaderboard.models.SkillIqLeader

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