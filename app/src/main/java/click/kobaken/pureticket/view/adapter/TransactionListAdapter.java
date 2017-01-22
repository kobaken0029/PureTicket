package click.kobaken.pureticket.view.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import click.kobaken.pureticket.R;
import click.kobaken.pureticket.databinding.ListTransactionHistoryBinding;
import io.soramitsu.irohaandroid.model.Transaction;

public class TransactionListAdapter extends BaseAdapter {
    private Context context;
    private List<Transaction> transactionHistory;
    private String publicKey;

    public TransactionListAdapter(Context context, List<Transaction> transactionHistory, String publicKey) {
        this.context = context;
        this.transactionHistory = transactionHistory;
        this.publicKey = publicKey;
    }

    @Override
    public int getCount() {
        return transactionHistory.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Transaction getItem(int position) {
        if (transactionHistory.size() <= position || position < 0) {
            return null;
        }
        return transactionHistory.get(position);
    }

    public void setItems(List<Transaction> transactionHistory) {
        this.transactionHistory = transactionHistory;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListTransactionHistoryBinding binding;
        if (convertView == null) {
            binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.list_transaction_history, parent, false);
            convertView = binding.getRoot();
            convertView.setTag(binding);
        } else {
            binding = (ListTransactionHistoryBinding) convertView.getTag();
        }
        binding.setTransaction(getItem(getCount() - 1 - position));
        binding.state.setBackground(ContextCompat.getDrawable(context, R.drawable.ic_send_money_24dp));
//        binding.setPublicKey(publicKey);
//        binding.setContext(context);
        return convertView;
    }
}
