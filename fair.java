void emv(int av,int no)   //Asset Value & No. of timers compromised as input
{
    int emv=0;
    emv= av*no;

    int risk=0;
    if(emv>=0&&emv<=999)
    {
        risk=0;
    }
    else if(emv>999&&emv<=9999)
    {
        risk=1;
    }
    else if(emv>9999&&emv<=99999)
    {
        risk=2;
    }
    else if(emv>99999)
    {
        risk=3;
    }
    
    System.out.println("The Risk associated with current scenario is:"+risk);
}