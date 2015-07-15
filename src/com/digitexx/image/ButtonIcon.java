package com.digitexx.image;

import javax.swing.Icon;
import javax.swing.JButton;

public class ButtonIcon extends JButton {

	public void setIconAndIconSelected(Icon icon, Icon icon_s) {
		setBorder(null);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		setFocusPainted(false);
		setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
		setVerticalTextPosition(javax.swing.SwingConstants.CENTER);
		setVerticalAlignment(javax.swing.SwingConstants.CENTER);
		setIcon(icon); // NOI18N
		setRolloverIcon(icon_s); // NOI18N
	}
}
