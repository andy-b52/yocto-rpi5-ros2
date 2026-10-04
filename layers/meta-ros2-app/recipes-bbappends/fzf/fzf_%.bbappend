# meta-ros lists the vendored Go modules' license as "Unknown", which do_create_spdx rejects.
# The unidentified licenses (golang.org/x/*, fastwalk go.LICENSE) are the Go BSD-3-Clause license.
GO_MOD_LICENSES = "Apache-2.0 & MIT & BSD-3-Clause"

# scarthgap go-vendor.bbclass: do_vendor_unlink removes the src/<GO_IMPORT>/vendor symlink
# that do_populate_lic reads the vendored license files through. Make sure licenses are
# collected first.
addtask vendor_unlink after do_populate_lic
