package group3.demonGame;

import java.awt.Image;


public class BonusReward extends gameObj{
    private int points = 250;
    private int count=0;
    private Score score;

    public BonusReward(int x, int y, Image ig, GameManager gm, Score score) {
        super(x, y, ig, gm);
        this.score = score;

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
//        this.gm.score += points;
          score.increaseScore(points);
    }

    @Override
    public void update() {
        if (count>=10)
        {
            gm.objList.remove(this);
        }
    }


}