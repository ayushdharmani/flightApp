// components/Header.js
import React from 'react';
import styled from 'styled-components';
import logoImage from '../components/indigo.png';

const HeaderContainer = styled.header`
  background-color: rgba(255, 255, 255, 0.1);
  padding: 1rem 2rem;
  display: flex;
  justify-content: space-between;
  align-items: center;
`;

const LogoName = styled.h1`
  color: white;
  margin: 0;
  font-size: 40px;
  font-weight: bold;
  align-items: center;
`;

const Logo = styled.img`
  height: 40px;
  margin: 0 0.5rem -0.5rem 0.5rem;
  width: auto;
`;

const Nav = styled.nav`
  display: flex;
  gap: 1rem;
`;

const NavLink = styled.a`
  color: white;
  text-decoration: none;
  font-size: 1rem;
  &:hover {
    text-decoration: underline;
  }
`;

function Header() {
  return (
    <HeaderContainer>
      <LogoName>IndiGo
        <Logo src={logoImage} alt="Indigo" />
      </LogoName>
      <Nav>
        <NavLink href="#home">Home</NavLink>
        <NavLink href="#flights">Flights</NavLink>
        <NavLink href="#about">About</NavLink>
        <NavLink href="#contact">Contact</NavLink>
      </Nav>
    </HeaderContainer>
  );
}

export default Header;