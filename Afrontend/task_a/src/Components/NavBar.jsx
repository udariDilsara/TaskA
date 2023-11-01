import React, { Component } from 'react';

class NavBar extends Component {
    render() {

        return (
            <div>
                <header>
                <nav class="navbar  navbar-dark bg-dark">
                <div class="container-fluid">
                    <a class="navbar-brand" href="/">Home</a>
                    <a class="navbar-brand" href="/drone">Drone</a>
                    <a class="navbar-brand" href="/loadmedications">Load Medication</a>
                </div>
                </nav>

                </header>
            </div>
        );
    }
}

export default NavBar;