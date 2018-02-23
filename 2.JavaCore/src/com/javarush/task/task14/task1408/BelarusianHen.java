package com.javarush.task.task14.task1408;

class BelarusianHen extends Hen {
    @Override
    int getCountOfEggsPerMonth() {
        return 300;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "Моя страна " + Country.MOLDOVA + ". Я несу " + getCountOfEggsPerMonth()
                + " яиц в месяц.";
    }
}
