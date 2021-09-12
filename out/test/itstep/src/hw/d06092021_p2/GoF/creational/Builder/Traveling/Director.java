package hw.d06092021_p2.GoF.creational.Builder.Traveling;

public class Director {
    VoucherBuilder builder;
    
    public void setBuilder(VoucherBuilder builder) {
        this.builder = builder;
    }

    Voucher buildVoucher() {
        builder.createVoucher();
        builder.buildName();
        builder.buildType();
        builder.buildTransport();
        builder.buildMeals();
        builder.buildPrice();
        Voucher voucher = builder.getVoucher();
        return voucher;
    }
}
