package utilities;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.JComboBox;

import sys_auto_Dao.VeiculoDao;

public class ComboListener {

    public static interface Function<T, R> {
        R apply(T input);
    }

    public static <T> ItemListener createModelComboListener(final JComboBox<String> manufacturerComboBox,
                                                            final JComboBox<String> modelComboBox,
                                                            VeiculoDao dao,
                                                            final Function<String, Set<T>> getBrandVehiclesMethod) {

        return new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedManufacturer = (String) manufacturerComboBox.getSelectedItem();

                    // Perform validation and handle the selected manufacturer as mentioned before
                    if (selectedManufacturer != null && !selectedManufacturer.equals("Selecione ...")) {
                        System.out.println(selectedManufacturer);

                        // Retrieve the items using the provided getBrandVehiclesMethod
                        Set<T> itemsSet = getBrandVehiclesMethod.apply(selectedManufacturer);

                        // Convert the Set to a List
                        List<T> itemsList = new ArrayList<>(itemsSet);

                        // Sort the items if needed

                        // Clear the model combo box
                        modelComboBox.removeAllItems();

                        // Add the items to the model combo box
                        for (T item : itemsList) {
                            modelComboBox.addItem(item.toString());
                        }
                    } else {
                        modelComboBox.removeAllItems();
                        // Handle the case for an invalid selection
                    }
                }
            }
        };
    }
}
