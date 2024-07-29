// App.js
import React, { useState, useEffect } from 'react';
import styled from 'styled-components';
import axios from 'axios';
import Header from './components/Header';
import FlightTable from './components/FlightTable';
import backgroundImage from './components/cloud.jpg';

const AnimatedContent = styled.div`
  opacity: 0;
  transform: translateY(20px);
  transition: opacity 0.5s ease-out, transform 0.5s ease-out;

  &.visible {
    opacity: 1;
    transform: translateY(0);
  }
`;

const AppContainer = styled.div`
  min-height: 100vh;
  background: linear-gradient(rgba(0, 51, 102, 0.8), rgba(0, 102, 153, 0.8)),
              url(${backgroundImage}) no-repeat center center fixed;
  background-size: cover;
  display: flex;
  flex-direction: column;
`;

const MainContent = styled.main`
  flex-grow: 1;
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 2rem;
`;

const Title = styled.h1`
  color: white;
  font-size: 3rem;
  margin-bottom: 1rem;
  text-shadow: 2px 2px 4px rgba(0,0,0,0.5);
`;

const Subtitle = styled.p`
  color: #e0e0e0;
  font-size: 1.2rem;
  margin-bottom: 2rem;
  text-align: center;
  max-width: 800px;
`;

function App() {
  const [flights, setFlights] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchFlights = async () => {
      try {
        setLoading(true);
        const response = await axios.get('http://localhost:8080/api/flights', {
          headers: {
            'ngrok-skip-browser-warning': '69420'
          }
        });
        console.log('API response:', response.data); // Add this line for debugging
        if (Array.isArray(response.data)) {
          setFlights(response.data);
        } else {
          throw new Error('API response is not an array');
        }
        setLoading(false);
      } catch (error) {
        console.error('Error fetching flights:', error);
        setError('Failed to fetch flight data. Please try again later.');
        setLoading(false);
      }
    };

    fetchFlights();
    const interval = setInterval(fetchFlights, 30000); // Refresh every 30 seconds

    return () => clearInterval(interval);
  }, []);

  return (
    <AppContainer>
      <Header />
      <MainContent>
        <Title>Real-Time Flight Information</Title>
        <Subtitle>
          Stay updated with the latest flight statuses from Indigo
        </Subtitle>
        {loading ? (
          <p>Loading flight data...</p>
        ) : error ? (
          <p>{error}</p>
        ) : (
          <FlightTable flights={flights} />
        )}
      </MainContent>
    </AppContainer>
  );
}

export default App;