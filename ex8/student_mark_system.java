import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class StudentMarkSystem extends JFrame implements ActionListener {
    JTextField tReg, tName, tS1, tS2, tS3, tS4, tS5;
    JButton bInsert, bView, bDelete, bUpdate;
    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    StudentMarkSystem() {
        setTitle("Student Mark System");
        setSize(500, 400);
        setLayout(new GridLayout(10, 2, 10, 10));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Labels
        add(new JLabel("Reg No:"));
        tReg = new JTextField();
        add(tReg);

        add(new JLabel("Name:"));
        tName = new JTextField();
        add(tName);

        add(new JLabel("Subject 1:"));
        tS1 = new JTextField();
        add(tS1);

        add(new JLabel("Subject 2:"));
        tS2 = new JTextField();
        add(tS2);

        add(new JLabel("Subject 3:"));
        tS3 = new JTextField();
        add(tS3);

        add(new JLabel("Subject 4:"));
        tS4 = new JTextField();
        add(tS4);

        add(new JLabel("Subject 5:"));
        tS5 = new JTextField();
        add(tS5);

        // Buttons
        bInsert = new JButton("Insert");
        bView = new JButton("View");
        bDelete = new JButton("Delete");
        bUpdate = new JButton("Update");

        add(bInsert);
        add(bView);
        add(bDelete);
        add(bUpdate);

        bInsert.addActionListener(this);
        bView.addActionListener(this);
        bDelete.addActionListener(this);
        bUpdate.addActionListener(this);

        connectDB();
        setVisible(true);
    }

    void connectDB() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.16.50:1521:ORACLE21C", "C##23BCS001", "C##23BCS001"); // change password if any
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Database Connection Error: " + e.getMessage());
        }
    }

    boolean validateFields() {
        if (tReg.getText().isEmpty() || tName.getText().isEmpty() ||
            tS1.getText().isEmpty() || tS2.getText().isEmpty() ||
            tS3.getText().isEmpty() || tS4.getText().isEmpty() || tS5.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields must be filled!");
            return false;
        }
        return true;
    }

    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == bInsert) {
                if (!validateFields()) return;

                int reg = Integer.parseInt(tReg.getText());
                String name = tName.getText();
                int s1 = Integer.parseInt(tS1.getText());
                int s2 = Integer.parseInt(tS2.getText());
                int s3 = Integer.parseInt(tS3.getText());
                int s4 = Integer.parseInt(tS4.getText());
                int s5 = Integer.parseInt(tS5.getText());
                float avg = (s1 + s2 + s3 + s4 + s5) / 5.0f;

                pst = con.prepareStatement("INSERT INTO student VALUES (?,?,?,?,?,?,?,?)");
                pst.setInt(1, reg);
                pst.setString(2, name);
                pst.setInt(3, s1);
                pst.setInt(4, s2);
                pst.setInt(5, s3);
                pst.setInt(6, s4);
                pst.setInt(7, s5);
                pst.setFloat(8, avg);
                pst.executeUpdate();

                JOptionPane.showMessageDialog(this, "Record Inserted Successfully!");
            }

            else if (e.getSource() == bView) {
                if (tReg.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Enter Register Number to View!");
                    return;
                }

                int reg = Integer.parseInt(tReg.getText());
                pst = con.prepareStatement("SELECT * FROM student WHERE regno=?");
                pst.setInt(1, reg);
                rs = pst.executeQuery();

                if (rs.next()) {
                    tName.setText(rs.getString("name"));
                    tS1.setText(rs.getString("sub1"));
                    tS2.setText(rs.getString("sub2"));
                    tS3.setText(rs.getString("sub3"));
                    tS4.setText(rs.getString("sub4"));
                    tS5.setText(rs.getString("sub5"));
                } else {
                    JOptionPane.showMessageDialog(this, "No Records Found!");
                }
            }

            else if (e.getSource() == bDelete) {
                if (tReg.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Enter Register Number to Delete!");
                    return;
                }
                int reg = Integer.parseInt(tReg.getText());
                pst = con.prepareStatement("DELETE FROM student WHERE regno=?");
                pst.setInt(1, reg);
                int count = pst.executeUpdate();
                if (count > 0)
                    JOptionPane.showMessageDialog(this, "Record Deleted Successfully!");
                else
                    JOptionPane.showMessageDialog(this, "No Records Found!");
            }

            else if (e.getSource() == bUpdate) {
                if (!validateFields()) return;

                int reg = Integer.parseInt(tReg.getText());
                String name = tName.getText();
                int s1 = Integer.parseInt(tS1.getText());
                int s2 = Integer.parseInt(tS2.getText());
                int s3 = Integer.parseInt(tS3.getText());
                int s4 = Integer.parseInt(tS4.getText());
                int s5 = Integer.parseInt(tS5.getText());
                float avg = (s1 + s2 + s3 + s4 + s5) / 5.0f;

                pst = con.prepareStatement("UPDATE student SET name=?,sub1=?,sub2=?,sub3=?,sub4=?,sub5=?,avgmarks=? WHERE regno=?");
                pst.setString(1, name);
                pst.setInt(2, s1);
                pst.setInt(3, s2);
                pst.setInt(4, s3);
                pst.setInt(5, s4);
                pst.setInt(6, s5);
                pst.setFloat(7, avg);
                pst.setInt(8, reg);
                int count = pst.executeUpdate();

                if (count > 0)
                    JOptionPane.showMessageDialog(this, "Record Updated Successfully!");
                else
                    JOptionPane.showMessageDialog(this, "No Records Found!");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new StudentMarkSystem();
    }
}
