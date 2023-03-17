package group3.demonGame;

import java.awt.Image;


public class BonusReward extends gameObj{
	private int points = 250;
    private int count=0;

    public BonusReward(int x, int y, Image ig, GameManager gm) {
        super(x, y, ig, gm);

        new Thread(new Runnable() {
            @Override
            public void run() {

                while (true){
                    count++;
                    try {
                        Thread.sleep(1000);
                        System.out.println(count);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();

    }

    public void getReward(){
        this.gm.score += points;
    }

    @Override
    public void update() {
        if (count>=10)
        {
            gm.objList.remove(this);
        }
    }


}