import React, { FormEvent, useState } from 'react';

const Signin = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');

  const handleLogin = (e:FormEvent) => {
    e.preventDefault();
    // Add your login logic here
  };

  return (
    <section id="signin">
      <h2>Signin</h2>
      <form onSubmit={handleLogin}>
        <input
          type="text"
          placeholder="Username"
          value={username}
          onChange={(e) => setUsername(e.target.value)}
        />
        <input
          type="password"
          placeholder="Password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />
        <button type="submit">Signin</button>
      </form>
    </section>
  );
};

export default Signin;
