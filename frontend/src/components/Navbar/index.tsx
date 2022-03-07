import {ReactComponent as GitHubIcon} from 'assents/img/github.svg';
import './styles.css';

function Navbar() {

    return (
        <header>
        <nav className="container">
            <div className="dsmovie-nav-content">
            <h1>DSMovie</h1>
            <a href="https://github.com/gefersonholdorf">
                <div className="dsmovie-contact-container">
                <GitHubIcon />
                <p className="dsmovie-contact-link">/gefersonholdorf</p>
                </div>
            </a>
            </div>
        </nav>
        </header>
    );
}

export default Navbar;