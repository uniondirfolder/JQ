package hw.d06092021_p2.GoF.creational.Builder.Traveling;

public abstract class VoucherBuilder {
    Voucher voucher;
    
    Voucher getVoucher() {
        return voucher;
    }
    
    public void createVoucher() {
        voucher = new Voucher();
    }

    public abstract void buildName();
    public abstract void buildType();
    public abstract void buildTransport();
    public abstract void buildMeals();
    public abstract void buildPrice();
}
