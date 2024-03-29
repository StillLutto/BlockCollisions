module me.lutto.blockcollisions {
    requires javafx.controls;
    requires javafx.fxml;


    opens me.lutto.blockcollisions to javafx.fxml;
    exports me.lutto.blockcollisions;
}