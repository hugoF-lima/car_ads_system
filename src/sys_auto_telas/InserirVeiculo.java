package sys_auto_telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JDesktopPane;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.UIManager;
import javax.swing.DropMode;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.ScrollPane;
import javax.swing.JTextArea;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import utilities.ImagePanel;
import utilities.MonetarioDocument;
import utilities.MonetarioDocument_2;
import utilities.SortedComboBoxModel;

import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.color.*;

import utilities.ComboListener;
import utilities.GeneralMethods;
import utilities.GradientPanel;
import sys_auto_beans.AnuncioBean;
import sys_auto_beans.ConsultarCarrVeicBean;
import sys_auto_beans.ConsultarMarcaVeicBean;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.awt.event.ActionEvent;
import sys_auto_beans.ConsultarMarcaVeicBean;
import sys_auto_Dao.AnuncioDao;
import sys_auto_Dao.VeiculoDao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JList;


public class InserirVeiculo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		UIManager.put( "control", new Color( 128, 128, 128) );
		  UIManager.put( "info", new Color(201, 195, 195) );
		  UIManager.put( "nimbusBase", new Color( 18, 30, 49) );
		  UIManager.put( "nimbusAlertYellow", new Color( 248, 187, 0) );
		  UIManager.put( "nimbusDisabledText", new Color( 128, 128, 128) );
		  UIManager.put( "nimbusFocus", new Color(115,164,209) );
		  UIManager.put( "nimbusGreen", new Color(176,179,50) );
		  UIManager.put( "nimbusInfoBlue", new Color( 66, 139, 221) );
		  UIManager.put( "nimbusLightBackground", new Color( 18, 30, 49) );
		  UIManager.put( "nimbusOrange", new Color(191,98,4) );
		  UIManager.put( "nimbusRed", new Color(169,46,34) );
		  UIManager.put( "nimbusSelectedText", new Color( 10, 10, 10) );
		  UIManager.put( "nimbusSelectionBackground", new Color( 104, 93, 156) );
		  UIManager.put( "text", new Color( 230, 230, 230) );
		  try {
		    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
		      if ("Nimbus".equals(info.getName())) {
		          javax.swing.UIManager.setLookAndFeel(info.getClassName());
		          break;
		      }
		    }
		  } catch (ClassNotFoundException e) {
		    e.printStackTrace();
		  } catch (InstantiationException e) {
		    e.printStackTrace();
		  } catch (IllegalAccessException e) {
		    e.printStackTrace();
		  } catch (javax.swing.UnsupportedLookAndFeelException e) {
		    e.printStackTrace();
		  } catch (Exception e) {
		    e.printStackTrace();
		  }
		  
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InserirVeiculo frame = new InserirVeiculo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	/**
	 * Variables Init.
	 */
	
	ImagePanel previewPanel;
	byte[] foto_Veiculo;
	
	
	private JTextArea descr_veic;
	JComboBox<Object> manufacter;
	JComboBox<Object> veiculo_model;
	JComboBox<Object> car_model;
	private JLabel fabr_lbl;
	private JLabel model_lbl;
	private JComboBox<Object> ano_Veic;
	private JLabel ano_lbl;
	JButton choose_veic_btn;
	private JTextField preco_veiculo;
	private JLabel combust_lbl;
	private JComboBox<Object> combst_combo;
	private JComboBox<Object> ipva_combo;
	private JLabel combust_lbl_1;
	private JLabel combust_lbl_2;
	private JComboBox<Object> cambio_combo;
	private JLabel combust_lbl_3;
	private JComboBox<Object> licenciado_combo;
	private JLabel lbl_preco_1;
	private JTextField km_field;
	JList<Object> Combst_List;
	final DefaultListModel<Object> listModel;
	
	Set<String> uniqueItems = new HashSet<>();
	
	AnuncioBean a = new AnuncioBean();
	
	

	/**
	 * Create the frame.
	 */
	public InserirVeiculo() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 586, 720);
		contentPane = new GradientPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		previewPanel = new ImagePanel(this.foto_Veiculo);
		previewPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		previewPanel.setBounds(270, 172, 278, 228);
		contentPane.add(previewPanel);
		
		
		descr_veic = new JTextArea();
		descr_veic.setBounds(74, 90, 278, 14);
		descr_veic.setLineWrap(true); // Enable line wrapping
		descr_veic.setWrapStyleWord(true); // Wrap at word boundaries
		contentPane.add(descr_veic);
		
		JScrollPane descrScroll = new JScrollPane(descr_veic);
		descrScroll.setBounds(10, 533, 353, 105);
		contentPane.add(descrScroll);
		
		JLabel lblNewLabel = new JLabel("Descrição:");
		lblNewLabel.setBounds(10, 508, 71, 14);
		contentPane.add(lblNewLabel);
		
		
		manufacter = new JComboBox<Object>();
		//Parse string from db connection?
		//f = ConsultarVeicBean();
		//f = test_sqlite.retornarVeic
		populateManufacterBox();
		AutoCompleteDecorator.decorate(manufacter);
		manufacter.setBounds(10, 39, 219, 22);
		contentPane.add(manufacter);
		manufacter.addItemListener(new ModelComboListener());
		
		fabr_lbl = new JLabel("Fabricante:");
		fabr_lbl.setBounds(10, 14, 71, 14);
		contentPane.add(fabr_lbl);
		
		veiculo_model = new JComboBox<Object>();
		veiculo_model.setBounds(270, 39, 219, 22);
		//populateModelBox();
		//AutoCompleteDecorator.decorate(car_model);
		contentPane.add(veiculo_model);
		veiculo_model.addItemListener(new CarListComboListener());
		
		model_lbl = new JLabel("Modelo:");
		model_lbl.setBounds(270, 14, 71, 14);
		contentPane.add(model_lbl);
		
		ano_Veic = new JComboBox<Object>();
		//AutoCompleteDecorator.decorate(car_model);
		ano_Veic.setBounds(10, 114, 110, 22);
		contentPane.add(ano_Veic);
		addItemsToList();
		
		
		
		ano_lbl = new JLabel("Ano:");
		ano_lbl.setBounds(10, 89, 71, 14);
		contentPane.add(ano_lbl);
		
		choose_veic_btn = new JButton("Foto Ve\u00EDculo");
		choose_veic_btn.setBounds(438, 411, 110, 23);
		contentPane.add(choose_veic_btn);
		
		choose_veic_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				escolherFoto();

				/*FilechooserWindow fcw = new FilechooserWindow();
				fcw.setVisible(true);
				ChooseFileField.write(new BufferedWriter(new FileWriter(fcw.fileChooser.getSelectedFile().getAbsolutePath() + fcw.fileChooser.getFileFilter().getDescription().replace("All Files", ""))));*/
			}
		});
		
		JButton choose_veic_btn_1 = new JButton("Criar Anuncio");
		choose_veic_btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillAnuncioBean(a);
				AnuncioDao.InserirAnuncio(a);
				a = new AnuncioBean();
				GeneralMethods.limpar(contentPane);
			}
		});
		choose_veic_btn_1.setBounds(426, 499, 122, 23);
		contentPane.add(choose_veic_btn_1);
		
		JLabel veic_lbl_1 = new JLabel("Ve\u00EDculo");
		veic_lbl_1.setBounds(270, 89, 71, 14);
		contentPane.add(veic_lbl_1);
		
		car_model = new JComboBox<Object>();
		car_model.setBounds(270, 114, 278, 22);
		contentPane.add(car_model);
		
		preco_veiculo = new JTextField();
		preco_veiculo.setBounds(10, 288, 159, 29);
		contentPane.add(preco_veiculo);
		preco_veiculo.setColumns(10);
		preco_veiculo.setDocument(new MonetarioDocument());
		
		JLabel lbl_preco = new JLabel("Pre\u00E7o:");
		lbl_preco.setBounds(10, 263, 46, 14);
		contentPane.add(lbl_preco);
		
		JButton CadastrarVeiculo = new JButton("+");
		CadastrarVeiculo.setToolTipText("Cadastrar Ve\u00EDculo");
		CadastrarVeiculo.setBounds(499, 39, 61, 23);
		contentPane.add(CadastrarVeiculo);
		
		combust_lbl = new JLabel("Combust\u00EDvel:");
		combust_lbl.setBounds(10, 332, 102, 14);
		contentPane.add(combust_lbl);
		
		ipva_combo = new JComboBox<Object>();
		ipva_combo.setBounds(10, 172, 110, 22);
		addItemsIn(Arrays.asList("sim", "não"), ipva_combo);
		contentPane.add(ipva_combo);
		
		combust_lbl_1 = new JLabel("IPVA em dia:");
		combust_lbl_1.setBounds(10, 147, 71, 14);
		contentPane.add(combust_lbl_1);
		
		combust_lbl_2 = new JLabel("Cambio:");
		combust_lbl_2.setBounds(138, 89, 71, 14);
		contentPane.add(combust_lbl_2);
		
		cambio_combo = new JComboBox<Object>();
		cambio_combo.setBounds(138, 114, 110, 22);
		addItemsIn(Arrays.asList("Manual", "Automático", "CVT"), cambio_combo);
		contentPane.add(cambio_combo);
		
		combust_lbl_3 = new JLabel("Licenciado:");
		combust_lbl_3.setBounds(148, 147, 71, 14);
		contentPane.add(combust_lbl_3);
		
		licenciado_combo = new JComboBox<Object>();
		licenciado_combo.setBounds(138, 172, 110, 22);
		addItemsIn(Arrays.asList("sim", "não"), licenciado_combo);
		contentPane.add(licenciado_combo);
		
		lbl_preco_1 = new JLabel("Km:");
		lbl_preco_1.setBounds(10, 205, 46, 14);
		contentPane.add(lbl_preco_1);
		
		km_field = new JTextField();
		km_field.setColumns(10);
		km_field.setBounds(10, 230, 159, 22);
		contentPane.add(km_field);
		
		listModel = new DefaultListModel<Object>();
		
		JScrollPane list_Scroll = new JScrollPane();
		list_Scroll.setBounds(10, 387, 181, 72);
		contentPane.add(list_Scroll);
		
		
		Combst_List = new JList<Object>();
		Combst_List.setBounds(109, 411, 181, 72);
		list_Scroll.setViewportView(Combst_List);
		
		final JButton add_combst = new JButton("Adic.");
		add_combst.setEnabled(false);
		add_combst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String combstItem = (String)combst_combo.getSelectedItem();
				if (!combstItem.isEmpty() && uniqueItems.add(combstItem)) {
				listModel.addElement(combstItem); 
				Combst_List.setModel(listModel);
				}
			}
		});
		add_combst.setBounds(130, 354, 61, 23);
		contentPane.add(add_combst);
		
		JButton remov_combst = new JButton("Remov.");
		remov_combst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listModel.remove(Combst_List.getSelectedIndex()); 
				Combst_List.setModel(listModel);
			}
		});
		remov_combst.setBounds(10, 474, 71, 23);
		contentPane.add(remov_combst);
		
		JButton remov_All = new JButton("Rem. Todos");
		remov_All.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listModel.clear(); 
				Combst_List.setModel(listModel);
			}
		});
		remov_All.setBounds(91, 474, 100, 23);
		contentPane.add(remov_All);
		
		combst_combo = new JComboBox<Object>();
		combst_combo.addItem("Diesel");
		combst_combo.addItem("Etanol");
		combst_combo.addItem("Gasolina");
		combst_combo.addItem("GNV");
		combst_combo.addItem("Eletrico");
		combst_combo.setBounds(10, 354, 110, 22);
		combst_combo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = combst_combo.getSelectedIndex();
                add_combst.setEnabled(selectedIndex != -1); // Enable button if selectedIndex is not -1
            }
        });
		contentPane.add(combst_combo);
		
		setDefaultSelectionForComboBoxes(combst_combo, ano_Veic, ipva_combo, licenciado_combo, cambio_combo);
		
		
		
		
	}
	
	private void populateManufacterBox() {
        VeiculoDao itemDAO = new VeiculoDao();
        //ConsultarVeicBean f = new ConsultarVeicBean();
        List<ConsultarMarcaVeicBean> items = itemDAO.getAllItems();
        manufacter.removeAll();
        manufacter.addItem("Selecione ...");
        for (ConsultarMarcaVeicBean item : items) {
        	System.out.println(items);
            manufacter.addItem(item.getFabricante());
        }
    }
	
	private String escolherFoto(){
		String path_of_file = ""; //this.ChooseFileField
		this.foto_Veiculo = GeneralMethods.showTelaEscolheImage(new File("C:\\"), this.previewPanel, path_of_file, this, "jpg", "gif");
		
		return path_of_file;
	}
	
	//I wonder if this can be reused as a template for any combobox, replacing needed values accordingly
	private class ModelComboListener implements ItemListener {
		
		VeiculoDao dao = new VeiculoDao();
	    @Override
	    public void itemStateChanged(ItemEvent e) {
	        if (e.getStateChange() == ItemEvent.SELECTED) {
	            String selectedManufacturer = (String) manufacter.getSelectedItem();

	            // Perform validation and handle the selected manufacturer as mentioned before
	            if (selectedManufacturer != null && !selectedManufacturer.equals("Selecione ...")) {
	                //System.out.println(selectedManufacturer);
	            	
	            	//Set used, given the need for unique values.
	                Set<ConsultarCarrVeicBean> itemsSet = dao.getBrandVehicles(selectedManufacturer);
	                
	                // Convert the Set to a List (So it may allow alphabetic order display)
	                List<ConsultarCarrVeicBean> itemsList = new ArrayList<>(itemsSet);

	                // Sort the items in alphabetical order based on the 'veiculo' property
	                //The collections take care of the sorting
	                Collections.sort(itemsList, new Comparator<ConsultarCarrVeicBean>() {
	                    @Override
	                    public int compare(ConsultarCarrVeicBean item1, ConsultarCarrVeicBean item2) {
	                        return item1.getVeiculo().compareToIgnoreCase(item2.getVeiculo());
	                    }
	                });
					//Proceed to the conditional value filling.
					 if (!itemsList.isEmpty()) { veiculo_model.removeAllItems(); for
					 (ConsultarCarrVeicBean item : itemsList) { veiculo_model.addItem(item.getVeiculo()); veiculo_model.setSelectedIndex(-1);
					 } } else { 
						 veiculo_model.removeAllItems();
						 // Handle the case when there are no items for the selected
					 }
					 
	            } else {
	            	veiculo_model.removeAllItems();
	                // Handle the case for an invalid selection
	            }
	        }
	    }
	}
	
	private class CarListComboListener implements ItemListener {
			
			VeiculoDao dao = new VeiculoDao();
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if (e.getStateChange() == ItemEvent.SELECTED) {
		        	String selectedBrand = (String) manufacter.getSelectedItem();
		            String selectedModel = (String) veiculo_model.getSelectedItem();
	
		            // Perform validation and handle the selected manufacturer as mentioned before
		            if (selectedModel != null && !selectedModel.equals("Selecione ...")) {
		            	System.out.println(selectedBrand);
		            	System.out.println(selectedModel);
		            	
		            	//Set used, given the need for unique values.
		                Set<ConsultarCarrVeicBean> itemsSet = dao.getCarVehicles(selectedBrand, selectedModel);
		                
		                // Convert the Set to a List (So it may allow alphabetic order display)
		                List<ConsultarCarrVeicBean> itemsList = new ArrayList<>(itemsSet);
	
		                // Sort the items in alphabetical order based on the 'veiculo' property
		                //The collections take care of the sorting
		                Collections.sort(itemsList, new Comparator<ConsultarCarrVeicBean>() {
		                    @Override
		                    public int compare(ConsultarCarrVeicBean item1, ConsultarCarrVeicBean item2) {
		                        return item1.getModelo().compareToIgnoreCase(item2.getModelo());
		                    }
		                });
						//Proceed to the conditional value filling.
						 if (!itemsList.isEmpty()) { car_model.removeAllItems(); for
						 (ConsultarCarrVeicBean item : itemsList) { car_model.addItem(item.getModelo()); car_model.setSelectedIndex(-1);
						 } } else { 
							 car_model.removeAllItems();
							 // Handle the case when there are no items for the selected
						 }
						 
		            } else {
		            	car_model.removeAllItems();
		                // Handle the case for an invalid selection
		            }
		        }
		    }
		}
	
	private void addItemsToList() {
	    int currentYear = Calendar.getInstance().get(Calendar.YEAR);
	    for (int year = currentYear; year >= 1930; year--) {
	        ano_Veic.addItem(String.valueOf(year)); // Add each year as a string to the JComboBox
	    }
	}
	
	private void setDefaultSelectionForComboBoxes(@SuppressWarnings("unchecked") JComboBox<Object>... comboBoxes) {
	    for (JComboBox<Object> comboBox : comboBoxes) {
	        comboBox.setSelectedIndex(-1);
	    }
	}

	
	private void addItemsIn(List<String> items, JComboBox<Object> ipva_combo2) {
		for (String item : items) {
            ipva_combo2.addItem(item); // Add each item to the JComboBox
        }
    }
	
	//This method serves to retrieve all the selections within the JList
	public String getListItemsAsString(JList<Object> combst_List2, String delimiter) {
	    //Some inner modelling i think
		ListModel<Object> model = combst_List2.getModel();
	    //A stringBuilder container for passing the values
		StringBuilder sb = new StringBuilder();

	    // Iterate over the elements in the model
	    for (int i = 0; i < model.getSize(); i++) {
	        String item = (String) model.getElementAt(i);
	        sb.append(item);

	        // Append the delimiter if it's not the last item
	        if (i < model.getSize() - 1) {
	            sb.append(delimiter);
	        }
	    }

	    // Convert the StringBuilder to a String
	    String result = sb.toString();

	    return result;
	}

	
	private void fillAnuncioBean(AnuncioBean a) {
	    
	        
		a.setAnunc_fabricante(manufacter.getSelectedItem().toString());
		a.setAnunc_modelo(veiculo_model.getSelectedItem().toString());
		String ano_veicStr = ano_Veic.getSelectedItem().toString();
		int ano_int = Integer.parseInt(ano_veicStr);
		a.setAnunc_anoVeic(ano_int);
		a.setAnunc_veiculo(car_model.getSelectedItem().toString());
		a.setIpva_StatusVeic(ipva_combo.getSelectedItem().toString());
		a.setLicenca_StatusVeic(licenciado_combo.getSelectedItem().toString());
		a.setFoto_Veic(foto_Veiculo);
		a.setKm_Veic(km_field.getText());
		a.setPreco_veiculo(preco_veiculo.getText());
		String fueltypes = getListItemsAsString(Combst_List, "-");
		a.setCombst_veiculo(fueltypes);
		a.setDescr_veic(descr_veic.getText());
		
	}
 }
