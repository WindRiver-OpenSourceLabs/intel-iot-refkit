SECTION = "graphical"
SUMMARY = "Graphviz - Graph Visualization Software"
HOMEPAGE = "http://www.graphviz.org"
LICENSE = "EPL-1.0"
DEPENDS = "cairo pango expat intltool-native gtk-doc gettext-native python gnulib gnulib-native libtool"

SRC_URI[md5sum] = "4ea6fd64603536406166600bcc296fc8"
SRC_URI[sha256sum] = "ca5218fade0204d59947126c38439f432853543b0818d9d728c589dfe7f3a421"

SRC_URI = " \
    http://download.openpkg.org/components/cache/graphviz/graphviz-${PV}.tar.gz \
    file://cross_compile.patch \
"
LIC_FILES_CHKSUM = "file://COPYING;md5=9109f5fc16cf963fb3cdd32781b3ce04"

FILES_${PN}-dev += " \
    ${libdir}/graphviz/*.so \
"

EXTRA_OECONF += "--with-expatlibdir=."

inherit autotools-brokensep pkgconfig

do_configure_prepend() {
	rm -rf ${S}/m4 ${S}/libltdl
}
