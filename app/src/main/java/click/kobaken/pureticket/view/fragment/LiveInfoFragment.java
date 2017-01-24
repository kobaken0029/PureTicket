package click.kobaken.pureticket.view.fragment;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import click.kobaken.pureticket.R;
import click.kobaken.pureticket.databinding.FragmentLiveInfoBinding;
import click.kobaken.pureticket.view.Navigator;

public class LiveInfoFragment extends Fragment {
    private static final String ARGS_LIVE_ID = "live_id";

    Navigator navigator;
    FragmentLiveInfoBinding binding;

    public static LiveInfoFragment newInstance(int liveId) {
        LiveInfoFragment fragment = new LiveInfoFragment();
        Bundle args = new Bundle();
        args.putInt(ARGS_LIVE_ID, liveId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Navigator) {
            navigator = (Navigator) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement Navigator");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_live_info, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = DataBindingUtil.bind(view);
        binding.getRoot().setOnClickListener(v -> {
            navigator.gotoRight("");
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle args = getArguments();
        switch (args.getInt(ARGS_LIVE_ID)) {
            case 0:
                binding.image.setImageDrawable(getActivity().getDrawable(R.drawable.suzuko_funfun));
                binding.artistName.setText("三森すずこ");
                binding.liveTitle.setText("三森すずこ 2nd LIVE 2015『Fun!Fun!Fantasic Funfair!』初日");
                break;
            case 1:
                binding.image.setImageDrawable(getActivity().getDrawable(R.drawable.choucho));
                binding.artistName.setText("Choucho");
                binding.liveTitle.setText("Lantis presents 「深窓音楽演奏会其の参」");
                break;
            default:
                binding.image.setImageDrawable(getActivity().getDrawable(R.drawable.urhara));
                binding.artistName.setText("上原ひろみ");
                binding.liveTitle.setText("Tokyo Bunka Kaikan(with Akiko Yano)");
                break;
        }
    }
}
