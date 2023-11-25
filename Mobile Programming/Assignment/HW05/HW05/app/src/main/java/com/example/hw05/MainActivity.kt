package com.example.hw05

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hw05.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), DataTransferListener, DataReviewListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.addMemberButton.setOnClickListener {
            val personalInfoFragment = PersonalInfoFragment()
            supportFragmentManager.beginTransaction()
                .replace(binding.middleFragmentContainer.id, personalInfoFragment)
                .commit()
        }
    }

    // DataTransferListener의 메서드 구현
    override fun onPersonalInfoFilled(student: Student) {
        // PersonalInfoFragment에서 호출될 때 실행할 작업을 여기에 추가합니다.
        // 예를 들어, AddressInfoFragment를 추가하는 등의 작업을 수행할 수 있습니다.

        val addressInfoFragment = AddressInfoFragment()
        // Bundle을 통해 데이터를 AddressInfoFragment로 전달할 수도 있습니다.
        val bundle = Bundle()
        bundle.putString("studentName", student.name)
        addressInfoFragment.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.middleFragmentContainer, addressInfoFragment)
            .commit()
    }

    override fun onAddressInfoFilled(address: String, postalCode: String, city: String) {
        // AddressInfoFragment에서 호출될 때 실행할 작업을 여기에 추가합니다.
        // 예를 들어, SubFragment를 추가하는 등의 작업을 수행할 수 있습니다.

        val subFragment = SubFragment()
        val bundle = Bundle()
        bundle.putString("address", address)
        bundle.putString("postalCode", postalCode)
        bundle.putString("city", city)
        subFragment.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.bottomFragmentContainer, subFragment, SubFragment.TAG)
            .commit()
    }

    // DataReviewListener의 메서드 구현
    override fun onReviewDataConfirmed(student: Student) {
        // SubFragment를 가져와서 데이터 전달
        val subFragment = supportFragmentManager.findFragmentByTag(SubFragment.TAG) as? SubFragment
        subFragment?.displayReviewData(student)
    }
}
