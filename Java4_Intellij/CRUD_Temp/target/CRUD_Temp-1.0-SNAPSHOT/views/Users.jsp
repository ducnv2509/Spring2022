<%--
  Created by IntelliJ IDEA.
  User: ducit
  Date: 3/20/2022
  Time: 12:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="cl" uri="http://cloudinary.com/jsp/taglib" %>
<!doctype html>
<html lang="en">

<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS v5.0.2 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        a.active{
            color: green;
            font-weight: bold;
        }
    </style>
    <base href="/CRUD_Temp_war/">

</head>

<body>
<div class="container">
    <img src="" class="img-responsive img-fluid" alt="">

    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Navbar</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="#">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Link</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                           data-bs-toggle="dropdown" aria-expanded="false">
                            Dropdown
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="#">Action</a></li>
                            <li><a class="dropdown-item" href="#">Another action</a></li>
                            <li>
                                <hr class="dropdown-divider">
                            </li>
                            <li><a class="dropdown-item" href="#">Something else here</a></li>
                        </ul>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled">Disabled</a>
                    </li>
                </ul>
                <form class="d-flex" method="post">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search"
                           name="search">
                    <button class="btn btn-outline-success" type="submit"
                            formaction="UserServlet/search"
                    >Search
                    </button>
                </form>
            </div>
        </div>
    </nav>

    <div class="row">
        <div class="col-md-9">
            <div class="row">
                <div class="col">
                    <c:if test="${not empty message}">
                        <div class="alert alert-success">${message}</div>

                    </c:if>
                    <c:if test="${not empty error}">
                        <div class="alert alert-danger">${error}</div>
                    </c:if>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <form action="UserServlet" method="post" enctype="multipart/form-data">
                        <div class="form-group">
                            <label for="">FullName</label>
                            <input type="text" name="fullName" class="form-control" value="${user.fullName}">
                        </div>
                        <div class="form-group">
                            <label for="">Email</label>
                            <input type="text" name="email" class="form-control"
                                   value="${user.email}"
                            >
                        </div>
                        <div class="form-group">
                            <label for="">Password</label>
                            <input type="password" name="password" class="form-control" value="${user.password}">
                        </div>

                        <div class="form-group">
                            <label for="">Address</label>
                            <input type="text" name="address" class="form-control" value="${user.address}">
                        </div>


                        <div class="form-group">
                            <label for="">Phone</label>
                            <input type="text" name="phone" class="form-control" value="${user.phone}">
                        </div>
                        <div class="mb-3">
                            <label for="formFile" class="form-label">Image</label>
                            <input class="form-control" type="file" id="formFile" name="avatar" value="${user.avatar}">
                        </div>
                        <div class="form-check">
                            <button class="btn btn-primary" formaction="UserServlet/create">Create</button>
                            <button class="btn btn-warning" formaction="UserServlet/update?id=${user.id}">Update
                            </button>
                            <button class="btn btn-danger" formaction="UserServlet/delete?id=${user.id}">Delete</button>
                            <button class="btn btn-info" formaction="UserServlet/reset">Reset</button>
                            <button class="btn btn-danger" formaction="UserServlet/search">Search</button>
                        </div>
                    </form>
                </div>

                <div class="col">
                    <div class="table-responsive">
                        <table class="table table-striped sortable">
                            <thead>
                            <tr>
                                <td>
                                    ID
                                </td>
                                <td>FullName</td>
                                <td>Email</td>
                                <td>Phone</td>
                                <td>Address</td>
                                <td>Image</td>
                                <td>&nbsp</td>
                            </tr>
                            </thead>
                            <tbody>
                            <%--                            <form class="d-flex">--%>
                            <%--                                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name = "fullName">--%>
                            <%--                                <button class="btn btn-outline-success" type="submit"--%>
                            <%--                                formaction="UserServlet/search?fullName=${user.fullName}"--%>
                            <%--                                >Search</button>--%>
                            <%--                            </form>--%>
                            <c:forEach var="item" items="${listA}">

                                <tr>
                                    <td>${item.id}</td>
                                    <td>${item.fullName}</td>
                                    <td>${item.email}</td>
                                    <td>${item.phone}</td>
                                    <td>${item.address}</td>
                                    <td>
                                            <%--                                                                                    <cl:image src="hkcbg16fa31vcplztvc0.jpg" />--%>
                                            <%--                                        <cl:image src="sample.jpg" alt="Sample Image"/>--%>
                                            <%--                                        <img src="https://res.cloudinary.com/ducnv2509/image/upload/v1648117681/hkcbg16fa31vcplztvc0.jpg" alt="">--%>
                                        <img src="${item.avatar}" class="img-fluid" width="150" height="200">
                                    </td>
                                    <td>
                                        <a href="UserServlet/edit?id=${item.id}">
                                            Edit
                                        </a>
                                        <a href="UserServlet/delete?id=${item.id}">
                                            Delete
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>

                            </tbody>
                        </table>
                        <c:forEach begin="1" end ="${endP}" var="i">
                            <a class="${tag == i ? "active" : ""}" href="/CRUD_Temp_war/UserServlet?index=${i}">${i}</a>
                        </c:forEach>
                    </div>
                </div>
            </div>

        </div>

        <div class="col-md-3">
            <div class="mb-3">
                <label for="exampleFormControlInput1" class="form-label">Email address</label>
                <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="name@example.com">
            </div>
            <div class="mb-3">
                <label for="exampleFormControlTextarea1" class="form-label">Example textarea</label>
                <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
            </div>

            <ol class="list-group list-group-numbered">
                <li class="list-group-item d-flex justify-content-between align-items-start">
                    <div class="ms-2 me-auto">
                        <div class="fw-bold">Subheading</div>
                        Content for list item
                    </div>
                    <span class="badge bg-primary rounded-pill">14</span>
                </li>
                <li class="list-group-item d-flex justify-content-between align-items-start">
                    <div class="ms-2 me-auto">
                        <div class="fw-bold">Subheading</div>
                        Content for list item
                    </div>
                    <span class="badge bg-primary rounded-pill">14</span>
                </li>
                <li class="list-group-item d-flex justify-content-between align-items-start">
                    <div class="ms-2 me-auto">
                        <div class="fw-bold">Subheading</div>
                        Content for list item
                    </div>
                    <span class="badge bg-primary rounded-pill">14</span>
                </li>
            </ol>
        </div>
    </div>

    <footer class="bg-danger text-center mt-5">
        Ducnv2509
    </footer>
</div>

<!-- Bootstrap JavaScript Libraries -->
<script type="text/javascript">
    var stIsIE = /*@cc_on!@*/false;
    sorttable = {
        init: function () {
// quit if this function has already been called
            if (arguments.callee.done) return;
// flag this function so we don't do the same thing twice
            arguments.callee.done = true;
// kill the timer
            if (_timer) clearInterval(_timer);

            if (!document.createElement || !document.getElementsByTagName) return;

            sorttable.DATE_RE = /^(\d\d?)[\/\.-](\d\d?)[\/\.-]((\d\d)?\d\d)$/;

            forEach(document.getElementsByTagName('table'), function (table) {
                if (table.className.search(/\bsortable\b/) != -1) {
                    sorttable.makeSortable(table);
                }
            });

        },

        makeSortable: function (table) {
            if (table.getElementsByTagName('thead').length == 0) {
// table doesn't have a tHead. Since it should have, create one and
// put the first table row in it.
                the = document.createElement('thead');
                the.appendChild(table.rows[0]);
                table.insertBefore(the, table.firstChild);
            }
// Safari doesn't support table.tHead, sigh
            if (table.tHead == null) table.tHead = table.getElementsByTagName('thead')[0];

            if (table.tHead.rows.length != 1) return; // can't cope with two header rows

// Sorttable v1 put rows with a class of "sortbottom" at the bottom (as
// "total" rows, for example). This is B&R, since what you're supposed
// to do is put them in a tfoot. So, if there are sortbottom rows,
// for backwards compatibility, move them to tfoot (creating it if needed).
            sortbottomrows = [];
            for (var i = 0; i < table.rows.length; i++) {
                if (table.rows[i].className.search(/\bsortbottom\b/) != -1) {
                    sortbottomrows[sortbottomrows.length] = table.rows[i];
                }
            }
            if (sortbottomrows) {
                if (table.tFoot == null) {
// table doesn't have a tfoot. Create one.
                    tfo = document.createElement('tfoot');
                    table.appendChild(tfo);
                }
                for (var i = 0; i < sortbottomrows.length; i++) {
                    tfo.appendChild(sortbottomrows[i]);
                }
                delete sortbottomrows;
            }

// work through each column and calculate its type
            headrow = table.tHead.rows[0].cells;
            for (var i = 0; i < headrow.length; i++) {
// manually override the type with a sorttable_type attribute
                if (!headrow[i].className.match(/\bsorttable_nosort\b/)) { // skip this col
                    mtch = headrow[i].className.match(/\bsorttable_([a-z0-9]+)\b/);
                    if (mtch) {
                        override = mtch[1];
                    }
                    if (mtch && typeof sorttable["sort_" + override] == 'function') {
                        headrow[i].sorttable_sortfunction = sorttable["sort_" + override];
                    } else {
                        headrow[i].sorttable_sortfunction = sorttable.guessType(table, i);
                    }
// make it clickable to sort
                    headrow[i].sorttable_columnindex = i;
                    headrow[i].sorttable_tbody = table.tBodies[0];
                    dean_addEvent(headrow[i], "click", sorttable.innerSortFunction = function (e) {

                        if (this.className.search(/\bsorttable_sorted\b/) != -1) {
// if we're already sorted by this column, just
// reverse the table, which is quicker
                            sorttable.reverse(this.sorttable_tbody);
                            this.className = this.className.replace('sorttable_sorted',
                                'sorttable_sorted_reverse');
                            this.removeChild(document.getElementById('sorttable_sortfwdind'));
                            sortrevind = document.createElement('span');
                            sortrevind.id = "sorttable_sortrevind";
                            sortrevind.innerHTML = stIsIE ? '&nbsp<font face="webdings">5</font>' : '&nbsp;&#x25B4;';
                            this.appendChild(sortrevind);
                            return;
                        }
                        if (this.className.search(/\bsorttable_sorted_reverse\b/) != -1) {
// if we're already sorted by this column in reverse, just
// re-reverse the table, which is quicker
                            sorttable.reverse(this.sorttable_tbody);
                            this.className = this.className.replace('sorttable_sorted_reverse',
                                'sorttable_sorted');
                            this.removeChild(document.getElementById('sorttable_sortrevind'));
                            sortfwdind = document.createElement('span');
                            sortfwdind.id = "sorttable_sortfwdind";
                            sortfwdind.innerHTML = stIsIE ? '&nbsp<font face="webdings">6</font>' : '&nbsp;&#x25BE;';
                            this.appendChild(sortfwdind);
                            return;
                        }

// remove sorttable_sorted classes
                        theadrow = this.parentNode;
                        forEach(theadrow.childNodes, function (cell) {
                            if (cell.nodeType == 1) { // an element
                                cell.className = cell.className.replace('sorttable_sorted_reverse', '');
                                cell.className = cell.className.replace('sorttable_sorted', '');
                            }
                        });
                        sortfwdind = document.getElementById('sorttable_sortfwdind');
                        if (sortfwdind) {
                            sortfwdind.parentNode.removeChild(sortfwdind);
                        }
                        sortrevind = document.getElementById('sorttable_sortrevind');
                        if (sortrevind) {
                            sortrevind.parentNode.removeChild(sortrevind);
                        }

                        this.className += ' sorttable_sorted';
                        sortfwdind = document.createElement('span');
                        sortfwdind.id = "sorttable_sortfwdind";
                        sortfwdind.innerHTML = stIsIE ? '&nbsp<font face="webdings">6</font>' : '&nbsp;&#x25BE;';
                        this.appendChild(sortfwdind);

// build an array to sort. This is a Schwartzian transform thing,
// i.e., we "decorate" each row with the actual sort key,
// sort based on the sort keys, and then put the rows back in order
// which is a lot faster because you only do getInnerText once per row
                        row_array = [];
                        col = this.sorttable_columnindex;
                        rows = this.sorttable_tbody.rows;
                        for (var j = 0; j < rows.length; j++) {
                            row_array[row_array.length] = [sorttable.getInnerText(rows[j].cells[col]), rows[j]];
                        }
                        /* If you want a stable sort, uncomment the following line */
//sorttable.shaker_sort(row_array, this.sorttable_sortfunction);
                        /* and comment out this one */
                        row_array.sort(this.sorttable_sortfunction);

                        tb = this.sorttable_tbody;
                        for (var j = 0; j < row_array.length; j++) {
                            tb.appendChild(row_array[j][1]);
                        }

                        delete row_array;
                    });
                }
            }
        },

        guessType: function (table, column) {
// guess the type of a column based on its first non-blank row
            sortfn = sorttable.sort_alpha;
            for (var i = 0; i < table.tBodies[0].rows.length; i++) {
                text = sorttable.getInnerText(table.tBodies[0].rows[i].cells[column]);
                if (text != '') {
                    if (text.match(/^-?[£$¤]?[\d,.]+%?$/)) {
                        return sorttable.sort_numeric;
                    }
// check for a date: dd/mm/yyyy or dd/mm/yy
// can have / or . or - as separator
// can be mm/dd as well
                    possdate = text.match(sorttable.DATE_RE)
                    if (possdate) {
// looks like a date
                        first = parseInt(possdate[1]);
                        second = parseInt(possdate[2]);
                        if (first > 12) {
// definitely dd/mm
                            return sorttable.sort_ddmm;
                        } else if (second > 12) {
                            return sorttable.sort_mmdd;
                        } else {
// looks like a date, but we can't tell which, so assume
// that it's dd/mm (English imperialism!) and keep looking
                            sortfn = sorttable.sort_ddmm;
                        }
                    }
                }
            }
            return sortfn;
        },

        getInnerText: function (node) {
// gets the text we want to use for sorting for a cell.
// strips leading and trailing whitespace.
// this is *not* a generic getInnerText function; it's special to sorttable.
// for example, you can override the cell text with a customkey attribute.
// it also gets .value for <input> fields.

            if (!node) return "";

            hasInputs = (typeof node.getElementsByTagName == 'function') &&
                node.getElementsByTagName('input').length;

            if (node.getAttribute("sorttable_customkey") != null) {
                return node.getAttribute("sorttable_customkey");
            } else if (typeof node.textContent != 'undefined' && !hasInputs) {
                return node.textContent.replace(/^\s+|\s+$/g, '');
            } else if (typeof node.innerText != 'undefined' && !hasInputs) {
                return node.innerText.replace(/^\s+|\s+$/g, '');
            } else if (typeof node.text != 'undefined' && !hasInputs) {
                return node.text.replace(/^\s+|\s+$/g, '');
            } else {
                switch (node.nodeType) {
                    case 3:
                        if (node.nodeName.toLowerCase() == 'input') {
                            return node.value.replace(/^\s+|\s+$/g, '');
                        }
                    case 4:
                        return node.nodeValue.replace(/^\s+|\s+$/g, '');
                        break;
                    case 1:
                    case 11:
                        var innerText = '';
                        for (var i = 0; i < node.childNodes.length; i++) {
                            innerText += sorttable.getInnerText(node.childNodes[i]);
                        }
                        return innerText.replace(/^\s+|\s+$/g, '');
                        break;
                    default:
                        return '';
                }
            }
        },

        reverse: function (tbody) {
// reverse the rows in a tbody
            newrows = [];
            for (var i = 0; i < tbody.rows.length; i++) {
                newrows[newrows.length] = tbody.rows[i];
            }
            for (var i = newrows.length - 1; i >= 0; i--) {
                tbody.appendChild(newrows[i]);
            }
            delete newrows;
        },

        /* sort functions
        each sort function takes two parameters, a and b
        you are comparing a[0] and b[0] */
        sort_numeric: function (a, b) {
            aa = parseFloat(a[0].replace(/[^0-9.-]/g, ''));
            if (isNaN(aa)) aa = 0;
            bb = parseFloat(b[0].replace(/[^0-9.-]/g, ''));
            if (isNaN(bb)) bb = 0;
            return aa - bb;
        },
        sort_alpha: function (a, b) {
            if (a[0] == b[0]) return 0;
            if (a[0] < b[0]) return -1;
            return 1;
        },
        sort_ddmm: function (a, b) {
            mtch = a[0].match(sorttable.DATE_RE);
            y = mtch[3];
            m = mtch[2];
            d = mtch[1];
            if (m.length == 1) m = '0' + m;
            if (d.length == 1) d = '0' + d;
            dt1 = y + m + d;
            mtch = b[0].match(sorttable.DATE_RE);
            y = mtch[3];
            m = mtch[2];
            d = mtch[1];
            if (m.length == 1) m = '0' + m;
            if (d.length == 1) d = '0' + d;
            dt2 = y + m + d;
            if (dt1 == dt2) return 0;
            if (dt1 < dt2) return -1;
            return 1;
        },
        sort_mmdd: function (a, b) {
            mtch = a[0].match(sorttable.DATE_RE);
            y = mtch[3];
            d = mtch[2];
            m = mtch[1];
            if (m.length == 1) m = '0' + m;
            if (d.length == 1) d = '0' + d;
            dt1 = y + m + d;
            mtch = b[0].match(sorttable.DATE_RE);
            y = mtch[3];
            d = mtch[2];
            m = mtch[1];
            if (m.length == 1) m = '0' + m;
            if (d.length == 1) d = '0' + d;
            dt2 = y + m + d;
            if (dt1 == dt2) return 0;
            if (dt1 < dt2) return -1;
            return 1;
        },

        shaker_sort: function (list, comp_func) {
// A stable sort function to allow multi-level sorting of data
// see: http://en.wikipedia.org/wiki/Cocktail_sort
// thanks to Joseph Nahmias
            var b = 0;
            var t = list.length - 1;
            var swap = true;

            while (swap) {
                swap = false;
                for (var i = b; i < t; ++i) {
                    if (comp_func(list[i], list[i + 1]) > 0) {
                        var q = list[i];
                        list[i] = list[i + 1];
                        list[i + 1] = q;
                        swap = true;
                    }
                } // for
                t--;

                if (!swap) break;

                for (var i = t; i > b; --i) {
                    if (comp_func(list[i], list[i - 1]) < 0) {
                        var q = list[i];
                        list[i] = list[i - 1];
                        list[i - 1] = q;
                        swap = true;
                    }
                } // for
                b++;

            } // while(swap)
        }
    }

    /* ******************************************************************
    Supporting functions: bundled here to avoid depending on a library
    ****************************************************************** */

    // Dean Edwards/Matthias Miller/John Resig

    /* for Mozilla/Opera9 */
    if (document.addEventListener) {
        document.addEventListener("DOMContentLoaded", sorttable.init, false);
    }

    /* for Internet Explorer */
    /*@cc_on @*/
    /*@if (@_win32)
    document.write("<script id=__ie_onload defer src=javascript:void(0)><\/script>");
    var script = document.getElementById("__ie_onload");
    script.onreadystatechange = function() {
        if (this.readyState == "complete") {
            sorttable.init(); // call the onload handler
        }
    };
    /*@end @*/

    /* for Safari */
    if (/WebKit/i.test(navigator.userAgent)) { // sniff
        var _timer = setInterval(function () {
            if (/loaded|complete/.test(document.readyState)) {
                sorttable.init(); // call the onload handler
            }
        }, 10);
    }

    /* for other browsers */
    window.onload = sorttable.init;

    // written by Dean Edwards, 2005
    // with input from Tino Zijdel, Matthias Miller, Diego Perini

    // http://dean.edwards.name/weblog/2005/10/add-event/

    function dean_addEvent(element, type, handler) {
        if (element.addEventListener) {
            element.addEventListener(type, handler, false);
        } else {
            // assign each event handler a unique ID
            if (!handler.$$guid) handler.$$guid = dean_addEvent.guid++;
            // create a hash table of event types for the element
            if (!element.events) element.events = {};
            // create a hash table of event handlers for each element/event pair
            var handlers = element.events[type];
            if (!handlers) {
                handlers = element.events[type] = {};
                // store the existing event handler (if there is one)
                if (element["on" + type]) {
                    handlers[0] = element["on" + type];
                }
            }
            // store the event handler in the hash table
            handlers[handler.$$guid] = handler;
            // assign a global event handler to do all the work
            element["on" + type] = handleEvent;
        }
    };
    // a counter used to create unique IDs
    dean_addEvent.guid = 1;

    function removeEvent(element, type, handler) {
        if (element.removeEventListener) {
            element.removeEventListener(type, handler, false);
        } else {
            // delete the event handler from the hash table
            if (element.events && element.events[type]) {
                delete element.events[type][handler.$$guid];
            }
        }
    };

    function handleEvent(event) {
        var returnValue = true;
        // grab the event object (IE uses a global event object)
        event = event || fixEvent(((this.ownerDocument || this.document || this).parentWindow || window).event);
        // get a reference to the hash table of event handlers
        var handlers = this.events[event.type];
        // execute each event handler
        for (var i in handlers) {
            this.$$handleEvent = handlers[i];
            if (this.$$handleEvent(event) === false) {
                returnValue = false;
            }
        }
        return returnValue;
    };

    function fixEvent(event) {
        // add W3C standard event methods
        event.preventDefault = fixEvent.preventDefault;
        event.stopPropagation = fixEvent.stopPropagation;
        return event;
    };
    fixEvent.preventDefault = function () {
        this.returnValue = false;
    };
    fixEvent.stopPropagation = function () {
        this.cancelBubble = true;
    }

    // Dean's forEach: http://dean.edwards.name/base/forEach.js
    /*
        forEach, version 1.0
        Copyright 2006, Dean Edwards
        License: http://www.opensource.org/licenses/mit-license.php
    */

    // array-like enumeration
    if (!Array.forEach) { // mozilla already supports this
        Array.forEach = function (array, block, context) {
            for (var i = 0; i < array.length; i++) {
                block.call(context, array[i], i, array);
            }
        };
    }

    // generic enumeration
    Function.prototype.forEach = function (object, block, context) {
        for (var key in object) {
            if (typeof this.prototype[key] == "undefined") {
                block.call(context, object[key], key, object);
            }
        }
    };

    // character enumeration
    String.forEach = function (string, block, context) {
        Array.forEach(string.split(""), function (chr, index) {
            block.call(context, chr, index, string);
        });
    };

    // globally resolve forEach enumeration
    var forEach = function (object, block, context) {
        if (object) {
            var resolve = Object; // default
            if (object instanceof Function) {
                // functions have a "length" property
                resolve = Function;
            } else if (object.forEach instanceof Function) {
                // the object implements a custom forEach method so use that
                object.forEach(block, context);
                return;
            } else if (typeof object == "string") {
                // the object is a string
                resolve = String;
            } else if (typeof object.length == "number") {
                // the object is array-like
                resolve = Array;
            }
            resolve.forEach(object, block, context);
        }
    };


</script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>

</body>

</html>
