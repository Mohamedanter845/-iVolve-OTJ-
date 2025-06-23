 Lab 3: SSH Configuration 🔐

This lab demonstrates how to set up secure SSH access using key-based authentication and configure SSH to simplify remote login commands.

🎯 Objectives

- Generate public/private SSH key pairs.
- Use `ssh-copy-id` to securely transfer the public key to the remote machine.
- Configure SSH client to allow connection with a short alias like `ssh ivolve`.


🛠️ Environment

- **Local Machine**: CentOS Stream 9
- **Remote Machine**: Simulated using `localhost` (for demo purposes)

 📦 Steps 

1️⃣ Generate SSH Key Pair


ssh-keygen

2️⃣ Copy Public Key to Remote Host

 ssh-copy-id mohamedanter@localhost

3️⃣ Configure SSH Client Alias

Host ivolve
    HostName localhost
    User mohamedanter




Now you can connect simply using:

ssh ivolve



✅ Result

Login via SSH now works without a password.

Simple command ssh ivolve provides fast access.


