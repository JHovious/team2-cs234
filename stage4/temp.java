DefaultTableModel model = (DefaultTableModel)tblTicket.getModel();
        for(int key : tickets.keySet()){
            String[] newRow = new String[] {String.valueOf(key), tickets.get(key).getTicketRecipient(), tickets.get(key).getTicketSubject(), tickets.get(key).getTicketPriority()};
            model.addRow(newRow);
        }
