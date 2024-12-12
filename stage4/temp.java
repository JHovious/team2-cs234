try{
            //Gets data from file
            BufferedReader reader = new BufferedReader(new FileReader("ticketdata.csv"));
            ArrayList<String> tableInfo = new ArrayList<>();
            String line;
            
            while ((line = reader.readLine()) != null){
                tableInfo.add(line);
            }
            reader.close();
            //Put data in table
            DefaultTableModel model = (DefaultTableModel)tblTicket.getModel();
            for(String rowInfo : tableInfo){
                String[] row = rowInfo.split(",");

                TicketDB ticket = new TicketDB(Integer.valueOf(row[0]), row[1], row[2], row[3], row[4]);
                tickets.put(Integer.valueOf(row[0]), ticket);
                String[] newRow = new String[] {row[0], row[1], row[2], row[3], row[4]};
                model.addRow(newRow);
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Data was not loaded correctly");
        }
