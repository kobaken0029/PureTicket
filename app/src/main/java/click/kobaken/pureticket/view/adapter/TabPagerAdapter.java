package click.kobaken.pureticket.view.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import click.kobaken.pureticket.R;
import click.kobaken.pureticket.view.fragment.TicketHistoryFragment;
import click.kobaken.pureticket.view.fragment.TransactionHistoryFragment;

public class TabPagerAdapter extends FragmentPagerAdapter {
    public static final String TAG = TabPagerAdapter.class.getSimpleName();

    private static final int TAB_COUNT = 2;

    private Context context;
    private Fragment currentFragment;

    public TabPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return TransactionHistoryFragment.newInstance();
        } else {
            return TicketHistoryFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        return TAB_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return context.getString(R.string.money);
        } else {
            return context.getString(R.string.ticket);
        }
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        if (currentFragment != object) {
            currentFragment = (Fragment) object;
        }
        super.setPrimaryItem(container, position, object);
    }

    public Fragment getCurrentFragment() {
        return currentFragment;
    }
}
