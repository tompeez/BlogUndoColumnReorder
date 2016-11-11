package de.hahn.blog.undocolumnreorder.view.beans;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.event.ActionEvent;

import oracle.adf.share.logging.ADFLogger;
import oracle.adf.view.rich.component.rich.data.RichColumn;
import oracle.adf.view.rich.component.rich.data.RichTable;

public class UndoColumnReorderBean {
    private static ADFLogger _logger = ADFLogger.createADFLogger(UndoColumnReorderBean.class);
    private RichTable table;

    public UndoColumnReorderBean() {
    }

    public void undoColunmReorder(ActionEvent actionEvent) {
        _logger.info("Undo reorder...");
        // get the tables child components
        List<UIComponent> children = this.table.getChildren();
        for (UIComponent comp : children) {
            // check if the child is a column
            if (comp instanceof RichColumn) {
                RichColumn col = (RichColumn) comp;
                // if hte display index is greater 0 set it to -1
                if (col.getDisplayIndex() >= 0) {
                    _logger.info("...unset column "+col);
                    col.setDisplayIndex(-1);
                }
            }
        }
        _logger.info("... done!");
    }

    public void setTable(RichTable table) {
        this.table = table;
    }

    public RichTable getTable() {
        return table;
    }
}
