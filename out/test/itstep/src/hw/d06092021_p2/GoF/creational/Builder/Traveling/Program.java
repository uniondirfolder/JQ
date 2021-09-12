package hw.d06092021_p2.GoF.creational.Builder.Traveling;

import java.util.ArrayList;

public class Program {

    public static void main(String[] args) {
        Director director = new Director();
        ArrayList<Voucher> vouchers = new ArrayList<Voucher>();
        director.setBuilder(new TripVoucherBuilder());
        vouchers.add(director.buildVoucher());
        director.setBuilder(new RestVoucherBuilder());
        vouchers.add(director.buildVoucher());
        for (Voucher voucher : vouchers) {
            System.out.println(voucher);
        }
    }
}
