package com.example.challengeapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.challengeapp.databinding.ActivityDetailBinding
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.CalendarMode
import java.util.*


class DetailActivity : AppCompatActivity() {

    private var mBinding: ActivityDetailBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*if(!intent.hasExtra("id")) {
            Toast.makeText(this, "챌린지 정보가 없습니다.", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, intent.getStringExtra("id"), Toast.LENGTH_SHORT).show()
        }*/

        if (intent.hasExtra("icon")) {
            binding.tvDetailIcon.setText(intent.getStringExtra("icon"))
        }

        if (intent.hasExtra("title")) {
            binding.tvDetailTitle.setText(intent.getStringExtra("title"))
        }

        if (intent.hasExtra("contents")) {
            binding.tvDetailContents.setText(intent.getStringExtra("contents"))
        }

        var startTimeCalendar = Calendar.getInstance()
        var endTimeCalendar = Calendar.getInstance()

        val currentYear = startTimeCalendar.get(Calendar.YEAR)
        val currentMonth = startTimeCalendar.get(Calendar.MONTH)
        //Log.d("currentMonth  ", currentMonth.toString())
        val currentDate = startTimeCalendar.get(Calendar.DATE)
        //Log.d("currentDate  ", currentDate.toString())

        endTimeCalendar.set(Calendar.MONTH, currentMonth)

        binding.mcDetail.state().edit()
            .setFirstDayOfWeek(Calendar.SUNDAY)
            .setMinimumDate(CalendarDay.from(currentYear, currentMonth, 1))
            .setMaximumDate(CalendarDay.from(currentYear, currentMonth, endTimeCalendar.getActualMaximum(Calendar.DAY_OF_MONTH)))
            .setCalendarDisplayMode(CalendarMode.MONTHS)
            .commit()

        val doneDateList = arrayListOf<CalendarDay>()
        doneDateList.add(CalendarDay.from(2022, 3, 3))
        doneDateList.add(CalendarDay.from(2022, 3, 8))
        val doneDecorator = DoneDecorator(doneDateList, this)
        binding.mcDetail.addDecorator(doneDecorator)
    }
}