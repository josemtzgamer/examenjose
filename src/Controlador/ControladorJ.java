package Controlador;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControladorJ {
	
	public void guardarEnBaseDatos(int ID, String NOMBRE, int DORSAL, Double ALTURA) {

		try {
			Class.forName("org.sqlite.JDBC");

			String url = "jdbc:sqlite:C:\\Users\\alumno tarde\\Desktop\\JOSE\\BASEJ.txt";

			Connection conexion = DriverManager.getConnection(url);

			if (conexion != null) {
				System.out.println("Hay conexión");
			} else {
				System.out.println("No hay conexión");
			}
			
			var pt = conexion.prepareStatement("INSERT INTO JUGADORES VALUES ( ? , ? , ? , ? ) ");
			pt.setInt(1, ID);
			pt.setString(2, NOMBRE);
			pt.setInt(3, DORSAL);
			pt.setDouble(4, ALTURA);
			
			pt.executeUpdate();

			if (conexion != null) {
				conexion.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
		}
	}
	
	/*public int Tamaño () {
		
		try {
			Class.forName("org.sqlite.JDBC");

			String url = "jdbc:sqlite:C:\\Users\\alumno tarde\\Desktop\\JOSE\\BASEJ.txt";

			Connection conexion = DriverManager.getConnection(url);
			
			
			
			if (conexion != null) {
				System.out.println("Hay conexión");
			} else {
				System.out.println("No hay conexión");
			}
			
			var pt = conexion.prepareStatement("select Count(*) FROM JUGADORES ");
			
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
		}
		return 4;
		
		
		
		
		
		
	}*/
	
	
	public boolean existeEnBaseDeDatos(int JUGADORES) {

		try {
			Class.forName("org.sqlite.JDBC");

			String url = "jdbc:sqlite:C:\\Users\\alumno tarde\\Desktop\\JOSE\\BASEJ.txt";

			Connection conexion = DriverManager.getConnection(url);

			if (conexion != null) {
				System.out.println("Hay conexión");
			} else {
				System.out.println("No hay conexión");
			}

			
	
			
			var pt = conexion.prepareStatement("SELECT * FROM JUGADORES WHERE ID = ? ");
			
			pt.setInt(1, JUGADORES);
			ResultSet rs = pt.executeQuery();

			if (conexion != null) {
				conexion.close();
			}

			return rs.next();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
		}

		return false;
	}
	
	
	public String listarBaseDeDatos() {

		try {
			Class.forName("org.sqlite.JDBC");

			String url = "jdbc:sqlite:C:\\Users\\alumno tarde\\Desktop\\JOSE\\BASEJ.txt";

			Connection conexion = DriverManager.getConnection(url);

			if (conexion != null) {
				System.out.println("Hay conexión");
			} else {
				System.out.println("No hay conexión");
			}

			var pt = conexion.prepareStatement("SELECT * FROM Jugadores ");
			ResultSet rs = pt.executeQuery();

			String mensaje = "";
			
			while(rs.next()) {
				mensaje += rs.getInt(1) + " | " +rs.getString(2)+" | "+ rs.getInt(3)+" | "+rs.getDouble(4);
				mensaje += "\n";
			}
			
			if (conexion != null) {
				conexion.close();
			}

			return mensaje;
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
		}

		return null;
	}

public void eliminarDeDaseDatos(int ID) {
		

		try {
			Class.forName("org.sqlite.JDBC");

			String url = "jdbc:sqlite:C:\\Users\\alumno tarde\\Desktop\\JOSE\\BASEJ.txt";

			Connection conexion = DriverManager.getConnection(url);

			if (conexion != null) {
				System.out.println("Hay conexión");
			} else {
				System.out.println("No hay conexión");
			}

			var pt = conexion.prepareStatement("DELETE FROM JUGADORES WHERE ID = ? ");
			pt.setInt(1, ID);

			pt.executeUpdate();

			if (conexion != null) {
				conexion.close();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
		}
}

		public void modificarEnBaseDeDatos(int ID, String NOMBRE, int DORSAL, Double ALTURA) {
			try {
				Class.forName("org.sqlite.JDBC");

				String url = "jdbc:sqlite:C:\\Users\\alumno tarde\\Desktop\\JOSE\\BASEJ.txt";


				Connection conexion = DriverManager.getConnection(url);

				if (conexion != null) {
					System.out.println("Hay conexión");
				} else {
					System.out.println("No hay conexión");
				}

				var pt = conexion.prepareStatement("UPDATE JUGADORES SET nombre = ? , Dorsal = ? , altura = ?  WHERE ID = ?");
				
				pt.setString(1, NOMBRE);
				pt.setInt(2, DORSAL);
				pt.setDouble(3, ALTURA);
				pt.setInt(4, ID);
				pt.executeUpdate();

				if (conexion != null) {
					conexion.close();
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
			}
	
}
		
		public int tamañoBD() {
		    int tamaño = 0;
		    try {
		        Class.forName("org.sqlite.JDBC");
		        String url = "jdbc:sqlite:C:\\Users\\alumno tarde\\Desktop\\JOSE\\BASEJ.txt";

		        try (Connection conexion = DriverManager.getConnection(url)) {
		            if (conexion != null) {
		                System.out.println("Hay conexión");
		            } else {
		                System.out.println("No hay conexión");
		            }

		            var pt = conexion.prepareStatement("SELECT COUNT(*) FROM JUGADORES");

		            ResultSet rs = pt.executeQuery();

		            if (rs.next()) {
		                tamaño = rs.getInt(1);
		            }
		        }
		    } catch (Exception e) {
		        JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
		    }

		    return tamaño;
		}
		public void volcar(JTable table_1) {
		    
		    try {
		        Class.forName("org.sqlite.JDBC");
		        String url = "jdbc:sqlite:C:\\Users\\alumno tarde\\Desktop\\JOSE\\BASEJ.txt";

		        try (Connection conexion = DriverManager.getConnection(url)) {
		            if (conexion != null) {
		                System.out.println("Hay conexión");
		            } else {
		                System.out.println("No hay conexión");
		            }

		          //  Statement leer = conect.createStatement();
		           // resultSet resultado = leer.executeQuery("SELECT * FROM JUGADORES");
		            
		            
		            var pt = conexion.prepareStatement("SELECT * FROM JUGADORES");

		            
		            DefaultTableModel model = new DefaultTableModel();
		            model.addColumn("ID");
		            model.addColumn("Nombre");
		            model.addColumn("Dorsal");
		            model.addColumn("Altura");
		            
		           
		            table_1.setModel(model);
		            String [] datos = new String [4];
		            
		            ResultSet rs = pt.executeQuery();
		            while (rs.next()) {
		                datos[0] = String.valueOf(rs.getInt(1));     // Convierte el entero a String
		                datos[1] = rs.getString(2);                 // Obtiene el valor como String directamente
		                datos[2] = String.valueOf(rs.getInt(3));    // Convierte el entero a String
		                datos[3] = String.valueOf(rs.getDouble(4)); // Convierte el double a String

		                model.addRow(datos);
		            }
		            
		            table_1.setModel(model);
		            
		            
		        }
		    } catch (Exception e) {
		        JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
		    }

		    
		}
		
		public int maxBD() {
		    int max = 0;
		    try {
		        Class.forName("org.sqlite.JDBC");
		        String url = "jdbc:sqlite:C:\\Users\\alumno tarde\\Desktop\\JOSE\\BASEJ.txt";

		        try (Connection conexion = DriverManager.getConnection(url)) {
		            if (conexion != null) {
		                System.out.println("Hay conexión");
		            } else {
		                System.out.println("No hay conexión");
		            }

		            var pt = conexion.prepareStatement("SELECT MAX(ID) FROM JUGADORES");

		            ResultSet rs = pt.executeQuery();

		            if (rs.next()) {
		                max = rs.getInt(1);
		            }
		        
		        }
		    } catch (Exception e) {
		        JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
		    }

		    return max;
		}
}