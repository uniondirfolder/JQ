package com.nvv.itstep.hw.d06092021_p2.GoF.creational.Builder.Traveling;

public class TripVoucherBuilder extends VoucherBuilder {

    @Override
    public void buildName() {
        voucher.setName("Trip to Minsk");
    }

    @Override
    public void buildType() {
        voucher.setType(Type.EXCURSION);
    }

    @Override
    public void buildTransport() {
        voucher.setTransport(Transport.TRAIN);
    }

    @Override
    public void buildMeals() {
        voucher.setMeals(Meals.LUNCH);
    }

    @Override
    public void buildPrice() {
        voucher.setPrice(200);
    }
}
