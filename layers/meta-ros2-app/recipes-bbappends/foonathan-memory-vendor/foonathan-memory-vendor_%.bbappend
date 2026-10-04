# The vendor's CMakeLists.txt checks for an installed foonathan_memory in a child
# "cmake --find-package" process, which does not see the Yocto sysroot. It then
# falls back to a git clone during do_compile, and BitBake blocks network access there.
# Point that check at the sysroot, where meta-ros' foonathan-memory recipe already installed it.
do_configure:prepend() {
    export CMAKE_PREFIX_PATH="${STAGING_DIR_HOST}${prefix}"
}
