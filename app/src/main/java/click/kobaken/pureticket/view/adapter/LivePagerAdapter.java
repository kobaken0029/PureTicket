package click.kobaken.pureticket.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import click.kobaken.pureticket.view.fragment.LiveInfoFragment;

public class LivePagerAdapter extends FragmentPagerAdapter {

    public LivePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return LiveInfoFragment.newInstance(0);
            case 1:
                return LiveInfoFragment.newInstance(1);
            default:
                return LiveInfoFragment.newInstance(2);
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Page " + (position + 1);
    }
}
