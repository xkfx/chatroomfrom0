package chatroom.client.ui.component.impl;

import javax.swing.*;
import java.awt.*;

/**
 * 消息显示窗，可以认为是 JTextArea 的代理类，
 * 具有和 JTextArea 一样的 displayMessage 方法。
 */
public class MessageDisplayPanel extends JPanel {

    private final JTextArea textArea;
    private final JScrollPane scrollPane;

    /**
     * 创建一个空的消息显示窗，具有确定的行数和列数。
     * @param rows the number of rows >= 0
     * @param columns the number of columns >= 0
     */
    public MessageDisplayPanel(int rows, int columns) {
        textArea = new JTextArea(rows, columns);
        textArea.setFont(new Font("楷体", 0, 25));
        textArea.setLineWrap(true);
        textArea.setEditable(false);

        scrollPane = new JScrollPane(textArea);

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
    }

    private void scrollToBottom(JScrollPane scrollPane) {
        JScrollBar jscrollBar = scrollPane.getVerticalScrollBar();
        if (jscrollBar != null) {
            jscrollBar.setValue(jscrollBar.getMaximum());
        }
    }

    /**
     * 将所给的文本追加到文档的底部，如果字符串为空就啥也不做。
     * @param str the text to insert
     */
    public void append(String str) {
        textArea.append(str);
        scrollToBottom(scrollPane);
    }
}
