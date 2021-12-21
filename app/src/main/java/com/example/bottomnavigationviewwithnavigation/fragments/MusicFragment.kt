package com.example.bottomnavigationviewwithnavigation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bottomnavigationviewwithnavigation.databinding.FragmentFriendsBinding
import com.example.bottomnavigationviewwithnavigation.databinding.FragmentHomeBinding
import com.example.bottomnavigationviewwithnavigation.databinding.FragmentMusicBinding

class MusicFragment : Fragment() {

    // layout의 fragment_home.xml을 만들었는데 여기서 알수없을으로 떳엇던 FragmentHomeBinding이 자동으로 바인딩 객체를 생성해줌
    private var mBinding : FragmentMusicBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentMusicBinding.inflate(inflater , container , false)

        // mBinding을 만드는 이유는 binding에서 받아온 Fragment를 메모리에 같이 올려주려고
        // 이는 곧 삭제할 때 onDestroyView에서 같이 메모리에서 삭제해주려고 만들어줌.
        mBinding = binding

        return mBinding?.root
    }

    override fun onDestroyView() {
        mBinding = null
        super.onDestroyView()
    }

}