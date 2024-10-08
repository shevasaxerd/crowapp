package services;

public class CountingCrowServiceImpl implements CountingCrowService{
    public int count;

    public CountingCrowServiceImpl(){
        count = 0;
    }


    public void increment(){
        count++;
    }


}
