import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class qipan_cover extends JFrame
{
 
private static final long serialVersionUID = 1L;

 
final static int N=3;
static int N2=(int)Math.pow(2,N); 
JButton[][] jbt=new JButton[N2][N2];
int m=0,n=0; 

 
Color[] colors={Color.YELLOW,Color.BLUE,Color.GREEN,Color.CYAN,Color.BLACK};
private int tile=0; 

 
public qipan_cover()
{
setLayout(new GridLayout(N2,N2,0,0));

 	
for(int a=0;a<N2;a++)
for(int b=0;b<N2;b++)
{
jbt[a][b]=new JButton("");
jbt[a][b].setBackground(Color.green);
add(jbt[a][b]);	
}

 
ButtonListener listener=new ButtonListener();
for(int a=0;a<N2;a++)
for(int b=0;b<N2;b++)
{
jbt[a][b].addActionListener(listener);
}       
}
 
class ButtonListener implements ActionListener
{

@Override
public void actionPerformed(ActionEvent e) 
{
// TODO Auto-generated method stub
for(int i=0;i<N2;i++)
for(int j=0;j<N2;j++)
{
if(e.getSource()==jbt[i][j])
{
changeColor(i,j); 
chessBoard(0,0,m,n,N2);
}
}	
}	
}

 
 
public void chessBoard(int tr,int tc,int dr,int dc,int size)
{
if(size==1)
return; 
int s=size/2; 
int t=(tile++)%colors.length;

//左上
if(dr<tr+s&&dc<tc+s)
chessBoard(tr,tc,dr,dc,s);

else 
{
jbt[tr+s-1][tc+s-1].setBackground(colors[t]);
chessBoard(tr,tc,tr+s-1,tc+s-1,s);
}

//左下
if(dr<tr+s && dc>=tc+s)
chessBoard(tr,tc+s,dr,dc,s);

else
{
jbt[tr+s-1][tc+s].setBackground(colors[t]);
chessBoard(tr,tc+s,tr+s-1,tc+s,s);
}

//右上
if(dr>=tr+s && dc<tc+s)
chessBoard(tr+s,tc,dr,dc,s);
else
{
jbt[tr+s][tc+s-1].setBackground(colors[t]);
chessBoard(tr+s,tc,tr+s,tc+s-1,s);
}


//右下
if(dr>=tr+s && dc>=tc+s)
chessBoard(tr+s,tc+s,dr,dc,s);

else
{
jbt[tr+s][tc+s].setBackground(colors[t]);
chessBoard(tr+s,tc+s,tr+s,tc+s,s);
}

}

 
public void changeColor(int i,int j){
jbt[i][j].setBackground(Color.red );
m=i;n=j; 	
}

 
public static void main(String[] args)
{
qipan_cover frameT=new qipan_cover();


frameT.setTitle("qipan_cover");
frameT.setSize(700, 700);
frameT.setLocationRelativeTo(null);
frameT.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frameT.setVisible(true);	
}	
 
}