// components/Background.js
import React from 'react';
import styled from 'styled-components';

const BackgroundContainer = styled.div`
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  z-index: -1;
  background: linear-gradient(to bottom, #003366, #006699);
  overflow: hidden;
`;

const Cloud = styled.div`
  position: absolute;
  background: rgba(255, 255, 255, 0.3);
  border-radius: 50%;
  animation: float ${props => props.duration}s infinite ease-in-out;
  
  &::before, &::after {
    content: '';
    position: absolute;
    background: inherit;
    border-radius: inherit;
  }
`;

function Background() {
  const clouds = [
    { top: '10%', left: '10%', width: '100px', height: '60px', duration: 20 },
    { top: '30%', left: '30%', width: '120px', height: '70px', duration: 25 },
    { top: '50%', left: '50%', width: '80px', height: '50px', duration: 18 },
    { top: '70%', left: '70%', width: '110px', height: '65px', duration: 22 },
  ];

  return (
    <BackgroundContainer>
      {clouds.map((cloud, index) => (
        <Cloud key={index} style={cloud} duration={cloud.duration} />
      ))}
    </BackgroundContainer>
  );
}

export default Background;