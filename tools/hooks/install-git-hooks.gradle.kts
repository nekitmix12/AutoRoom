tasks.register("installGitHooks", Copy::class.java) {
    from(File(rootProject.rootDir, "tools/hooks/pre-commit"))
    into(File(rootProject.rootDir, ".git/hooks"))
    filePermissions {
        user {
            read = true
            write = true
            execute = true
        }
        group {
            read = true
            execute = true
        }
        other {
            read = true
            execute = true
        }
    }
}