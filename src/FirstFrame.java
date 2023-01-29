import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FirstFrame extends JFrame {
    ArrayList<Doctor> doctors = new ArrayList<>();

    public FirstFrame(ArrayList<Doctor> doctors) {
        setTitle("DOCTOR DETAILS");
        setSize(800, 800);
        setLayout(new BorderLayout());
        this.doctors = doctors;


        DoctorsTablePatern doctorsTableModel = new DoctorsTablePatern();
        DoctorsTable doctorsTable = new DoctorsTable(doctorsTableModel);
        add(new JScrollPane(doctorsTable), BorderLayout.CENTER);

        Button b  =new Button("Back");
        add(new JScrollPane(b), BorderLayout.PAGE_END);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HomeFrame backTableFrame = new HomeFrame(doctors);
                backTableFrame.setVisible(true);
            }
        });
    }


    public class DoctorsTable extends JTable {
        public DoctorsTable(AbstractTableModel model) {
            super(model);
            setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            setRowSorter(new TableRowSorter<>(new DoctorsTablePatern()));
        }
    }

    public class DoctorsTablePatern extends AbstractTableModel {
        String[] columns = {"First Name", "Surname", "Medical Lic.NO", "Specialisation","Mobile NO"};
        Class[] columnClasses = new Class[]{
                String.class,
                String.class,
                Integer.class,
                String.class,
                Integer.class
        };

        /**
         * Returns the number of rows in the model. A
         * <code>JTable</code> uses this method to determine how many rows it
         * should display.  This method should be quick, as it
         * is called frequently during rendering.
         *
         * @return the number of rows in the model
         * @see #getColumnCount
         */
        @Override
        public int getRowCount() {

            return doctors.size();
        }

        /**
         * Returns the number of columns in the model. A
         * <code>JTable</code> uses this method to determine how many columns it
         * should create and display by default.
         *
         * @return the number of columns in the model
         * @see #getRowCount
         */
        @Override
        public int getColumnCount() {

            return columns.length;
        }

        /**
         * Returns the value for the cell at <code>columnIndex</code> and
         * <code>rowIndex</code>.
         *
         * @param rowIndex    the row whose value is to be queried
         * @param columnIndex the column whose value is to be queried
         * @return the value Object at the specified cell
         */
        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            switch (columnIndex) {
                case 0 -> {
                    return doctors.get(rowIndex).getName();
                }
                case 1 -> {
                    return doctors.get(rowIndex).getSurname();
                }
                case 2 -> {
                    return doctors.get(rowIndex).getLicenceNo();
                }
                case 3 -> {
                    return doctors.get(rowIndex).getSpecialisation();
                }
                case 4 -> {
                    return doctors.get(rowIndex).getMobileNo();
                }
                default -> {
                    return null;
                }
            }
        }

        /**
         * Returns a default name for the column using spreadsheet conventions:
         * A, B, C, ... Z, AA, AB, etc.  If <code>column</code> cannot be found,
         * returns an empty string.
         *
         * @param column the column being queried
         * @return a string containing the default name of <code>column</code>
         */
        @Override
        public String getColumnName(int column) {
            return columns[column];
        }

        /**
         * Returns <code>Object.class</code> regardless of <code>columnIndex</code>.
         *
         * @param columnIndex the column being queried
         * @return the Object.class
         */
        @Override
        public Class<?> getColumnClass(int columnIndex) {

            return columnClasses[columnIndex];
        }

    }
}

