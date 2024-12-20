import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class BoardPanel extends JFrame implements ActionListener{
    JPanel jp1=new JPanel();
    JPanel board=new JPanel();
    JButton boardbutton[][]=new JButton[4][4];
    JLabel l1=new JLabel();
    Color color_blank_button=new Color(197,183,170);
    Color color_2=new Color(240,240,240);
    Color color_4=new Color(237,224,200);
    Color color_8=new Color(242,177,121);
    Color color_16=new Color(245,149,99);
    Color color_32=new Color(246,124,95);
    Color color_64=new Color(246,94,59);
    Color color_128=new Color(237,207,114);
    Color color_256=new Color(237,204,97);
    Color color_512=new Color(237,200,80);
    Color color_1024=new Color(237,197,63);
    Color color_2048=new Color(237,194,46);
    

    BoardPanel(){
        setVisible(true);
        setResizable(false);
        setLocation(420,50);
        setTitle("2048 Game");
        setSize(400,450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        l1.setBackground(Color.gray);
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setText("Score:0");
        Font f1=new Font("Arial",Font.BOLD,20);
        l1.setFont(f1);

        jp1.setLayout(new BorderLayout());
        jp1.add(l1);
        add(jp1,BorderLayout.NORTH);
        
        //centerPanel
        board.setLayout(new GridLayout(4,4));
        board.setBackground(Color.gray);
        add(board);  


        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                JButton box=new JButton();
                boardbutton[i][j]=box;
                board.add(box);
                box.setBackground(color_blank_button);
                Font f2=new Font("Arial",Font.BOLD,100);
                box.setFont(f2);
                box.addActionListener(this);
            }
        }
        boardbutton[0][0]=setNumber(2);
        
    }

    public void setNumber(int n)
    {
        switch(n){
            case 2:setBackground(color_2);
            break;
            case 4:setBackground(color_4);
            break;
            case 8:setBackground(color_8);
            break;
            case 16:setBackground(color_16);
            break;
            case 32:setBackground(color_32);
            break;
            case 64:setBackground(color_64);
            break;
            case 128:setBackground(color_128);
            break;
            case 256:setBackground(color_256);
            break;
            case 512:setBackground(color_512);
            break;
            case 1024:setBackground(color_1024);
            break;
            case 2048:setBackground(color_2048);
            break;
        }
    }
    public void actionPerformed(ActionEvent e) {

    }
}
class game1{
    public static void main(String[] args) {
        new BoardPanel();
    }
}