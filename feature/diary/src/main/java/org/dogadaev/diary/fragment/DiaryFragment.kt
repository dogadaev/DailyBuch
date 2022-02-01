package org.dogadaev.diary.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import org.dogadaev.diary.R
import org.dogadaev.diary.databinding.FragmentDiaryLayoutBinding
import org.dogadaev.diary.presentation.DiaryViewInteractor
import org.dogadaev.navigation.Navigator
import org.dogadaev.presentation.extension.assistedViewModels
import org.dogadaev.presentation.viewmodel.DiaryViewModel
import org.dogadaev.presentation.viewmodel.factory.AssistedViewModelFactory
import org.dogadaev.ui.extensions.viewBinding

class DiaryFragment(
    navigator: Navigator,
    assistedFactory: AssistedViewModelFactory
) : Fragment(R.layout.fragment_diary_layout) {

    private val args: DiaryFragmentArgs by navArgs()
    private val binding by viewBinding(FragmentDiaryLayoutBinding::bind)
    private val viewModel: DiaryViewModel by assistedViewModels(assistedFactory) {
        DiaryViewModel.Payload(args.diaryId)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DiaryViewInteractor(this, binding, viewModel)
    }
}