/*
 * Copyright (c) 2014, 2019 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v. 1.0, which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */

package jakarta.tutorial.dukesbookstore.web.managedbeans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import jakarta.tutorial.dukesbookstore.dto.BookDTO;

/**
 * <p>Backing bean for the <code>/bookdetails.xhtml</code> page.</p>
 */
@Named("details")
@SessionScoped
public class BookDetailsBean extends AbstractBean implements Serializable {

    private static final long serialVersionUID = 2209748452115843974L;

    /**
     * <p>Add the displayed item to our shopping cart.</p>
     * @return the navigation page
     */
    public String add() {
        BookDTO book = (BookDTO) context().getExternalContext()
                .getSessionMap().get("selected");
        cart.add(book.getBookId(), book);
        message(null, "ConfirmAdd", new Object[]{book.getTitle()});

        return ("bookcatalog");
    }
}
